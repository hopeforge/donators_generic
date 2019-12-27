#Serviços 
Endpoint - https://172.31.15.21:8080/
   ```
 -Doador
        /doador/listaPorEmail - Serviço responsavel por buscar Doador pelo email cadastrado.
            -HTTP-Method: GET 
            -Parametros: email
```


```
        /doador/ - Serviço responsavel por cadastrar doador.
            -HTTP-Method: POST
            -Parametros: nome,email
```


   ```
 -Cupom
        /cupom/listar - Serviço responsavel por listar Todos cupons cadastrado
            -HTTP-Method: GET
            -Parametros:
        /cupom/uploadFile - Serviço responsavel por registrar doação de cupom e contabilizar pontos para o doador.
        -HTTP-Method: POST
        -Parametros:file,email
```


```
-Descontos(Parceiros)
        /parceiros/listaDescontos - Serviço responsavel por listar todos desconto em parceiros baseado na pontuação do Doador.
        -HTTP-Method: GET
        -Parametros: email
```




```
/parceiros/resgatar - Serviço responsavel por registrar o resgate(utilização do Desconto) no parceiro.
        -HTTP-Method: POST
        -Parametros: id("Id do desconto"), email
```



