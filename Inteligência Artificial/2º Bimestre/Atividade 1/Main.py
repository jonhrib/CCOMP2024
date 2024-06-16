# transformar em atributos categóricos as colunas gênero e estado civil
# divisão: pode dividir com uma coluna de valores 0 e 1 (se é um teste ou não)
import pandas as pd

dados = pd.read_csv("C:\\Users\\jonhv\\OneDrive\\Documentos\\IA2024\\Atividade13-06\\BaseDados.csv")

print(dados)

dados['Teste'] = 0
dados['Treinamento'] = 0

dados.to_csv('C:\\Users\\jonhv\\OneDrive\\Documentos\\IA2024\\Atividade13-06\\BaseDados_Nova.csv', index=False)

