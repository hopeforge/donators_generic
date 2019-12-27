from PIL import Image # Importando o módulo Pillow para abrir a imagem no script

import sys
import pytesseract # Módulo para a utilização da tecnologia OCR
fileName = sys.argv[1]
#print (sys.argv[1])
dados = pytesseract.image_to_string(Image.open(fileName))
print(dados) # Extraindo o texto da imagem
