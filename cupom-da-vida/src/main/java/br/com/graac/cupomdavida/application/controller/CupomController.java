package br.com.graac.cupomdavida.application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.graac.cupomdavida.application.entidades.Cupom;
import br.com.graac.cupomdavida.application.entidades.Doador;
import br.com.graac.cupomdavida.application.service.CupomService;
import br.com.graac.cupomdavida.application.service.DoadorService;

@RestController
@RequestMapping("/cupom")
@CrossOrigin(origins = "*")
public class CupomController {

	@Autowired
	private CupomService  cupomService;

	@Autowired
	private DoadorService doadorService;
	
	private final Logger logger = Logger.getLogger(CupomService.class);
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cupom>> listarCupom() {
		return new ResponseEntity<List<Cupom>>(cupomService.listaTodosCupons(), HttpStatus.OK);
	}
	

    @PostMapping("/uploadFile")
	public void upload(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
		try {
			//GoogleCredentials cred = GoogleCredentials.fromStream(new FileInputStream(new File("")));
//			Resource resource = new ClassPathResource("file:/home/sergio-moreira/cupom-fiscal.png");//this.resourceLoader.getResource("/home/sergio-moreira/Imagens/cupom-fiscal.png");
//			InputStream stream = resource.getInputStream();
			
//			String texto = template.extractTextFromImage(file.getResource());
//			System.out.println(texto);
			Doador doador = doadorService.findByEmail(email);
			File fileTmp = new File("/tmp/" + file.getName());
			fileTmp.delete();
			FileOutputStream fileOutputStream = new FileOutputStream(fileTmp);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.flush();
			fileOutputStream.close();
			Cupom cupom = parseImageToCupom(fileTmp.getAbsolutePath());
			cupom.setDoador(doador);
			doador.setPontuacao(doador.getPontuacao()+1);
			doador.getCupons().add(cupom);
			doadorService.cadastrar(doador);
			System.out.println("FILE: " + file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private Cupom parseImageToCupom(String path) {
		try {
			Process exec = Runtime.getRuntime().exec("python3 teste.py " + path);
			InputStream inputStream = exec.getInputStream();
			BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer conteudo = new StringBuffer(); 
			String line = "";
			while((line = bfr.readLine()) != null) 
			{
				System.out.println(line);
				conteudo.append(line).append("\n");
			}
			line = conteudo.toString();
			Cupom cupom = new Cupom();
			cupom.setDadosCupom(line);
			cupom.setDataCadastro(new Date());
			try {
				if(line.contains("/")) {
					cupom.setDataCupom(parseToDate(line.substring(line.indexOf("/")-2, line.length()-1)));
				}else {
					cupom.setDataCupom(new Date());
				}
				if(line.contains("COD") || line.toUpperCase().contains("C0d") || line.toUpperCase().contains("Co0")) {
					cupom.setNumeroCupom(line.substring(line.indexOf("COD")-1, line.length()-1));
				}else {
					cupom.setNumeroCupom(String.valueOf(System.currentTimeMillis()));
				}
				if(line.contains("CNPJ")) {
					cupom.setCnpj(line.substring(line.toUpperCase().indexOf("CNPJ")-1, line.length()-1));
				}
			}catch(StringIndexOutOfBoundsException e) {}
			return cupom;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static void main(String[] args) {
		String cp = "     sdsdsdsdsd  \n sfww WEEW \n COD:000002 \n \n \n \n 22/05/2019 15:00:00";
		System.out.println(cp.substring(cp.indexOf("/")-2, cp.length()-1));
	}
    
    private Date parseToDate(String data) {
    	try {
    		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return fmt.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
}
