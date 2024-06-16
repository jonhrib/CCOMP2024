# transformar em atributos categóricos as colunas gênero e estado civil
# divisão: pode dividir com uma coluna de valores 0 e 1 (se é um teste ou não)
import pandas as pd
from sklearn.model_selection import train_test_split

dados = pd.read_csv("C:\\Users\\jonhv\\OneDrive\\Documentos\\IA2024\\Atividade13-06\\BaseDados.csv") #lendo o arquivo csv do computador

dados = dados.dropna(how = 'any') #retirando todas as linhas que existirem pelo menos um valor NaN

dados = dados.drop_duplicates() #retira as duplicidades

dados['Masculino'] = 0
dados['Feminino'] = 0
dados['Solteiro(a)'] = 0
dados['Casado(a)'] = 0
dados['Divorciado(a)'] = 0
dados['Viúvo(a)'] = 0
dados['Teste'] = 0 #criando a coluna Teste e colocando 0 para todos 
dados['Treinamento'] = 0 #criando a coluna Treinamento e colocando 0 para todos

for indice, linha in dados.iterrows(): 
    if linha['Gênero'] == 'Masculino': 
         dados.at[indice, 'Masculino'] = 1 
         
for indice, linha in dados.iterrows():
    if linha['Gênero'] == 'Feminino': 
         dados.at[indice, 'Feminino'] = 1 
         
dados = dados.drop('Gênero', axis=1) #exclui a coluna

for indice, linha in dados.iterrows(): #itera sob todas as linhas da base de dados
    if linha['Estado_Civil'] == 'Solteiro(a)': #se o conteúdo da coluna Estado_Civil for Solteiro(a)
         dados.at[indice, 'Solteiro(a)'] = 1 #adiciona o número 1 na mesma linha, mas na coluna Solteiro(a)
         
for indice, linha in dados.iterrows():
    if linha['Estado_Civil'] == 'Casado(a)':
         dados.at[indice, 'Casado(a)'] = 1
         
for indice, linha in dados.iterrows():
    if linha['Estado_Civil'] == 'Divorciado(a)':
         dados.at[indice, 'Divorciado(a)'] = 1
         
for indice, linha in dados.iterrows():
    if linha['Estado_Civil'] == 'Viúvo(a)':
         dados.at[indice, 'Viúvo(a)'] = 1
         
dados = dados.drop('Estado_Civil', axis=1) #exclui a coluna Estado_Civil

dados = dados[['ID_Cliente', 'Idade', 'Feminino', 'Masculino', 'Solteiro(a)', 'Casado(a)', 'Divorciado(a)', 'Viúvo(a)', 'Profissão', 'Salário', 'Teste', 'Treinamento']] #reoordenando as colunas

# Divisão dos dados em conjunto de treinamento e teste
treinamento, teste = train_test_split(dados, test_size=0.2, random_state=42) #divide a base de dados 'dados' em duas, uma de treinamento e outra de teste, com o tamanho do teste setado em 20%, e um número inteiro (semente) para a geração de números aleatórios, garantindo que sempre essa execução gere o mesmo resultado

# Marcação das linhas como pertencentes ao conjunto de treinamento ou teste diretamente no DataFrame original
dados.loc[treinamento.index, 'Teste'] = 0 #em 'dados', colocamos 0 na coluna 'Teste' para todos as linhas condizentes com a base 'treinamento'
dados.loc[treinamento.index, 'Treinamento'] = 1 #em 'dados', colocamos 1 na coluna 'Treinamento' para todas as linhas condizentes com a base 'treinamento'

dados.loc[teste.index, 'Teste'] = 1
dados.loc[teste.index, 'Treinamento'] = 0

pd.set_option('display.max_rows', None) #ajustando as configurações do pandas, permitindo que possamos exibir várias linhas, retira o máximo

print(dados) #imprime a tabela

dados.to_csv('C:\\Users\\jonhv\\OneDrive\\Documentos\\IA2024\\Atividade13-06\\BaseDados_Nova.csv', index=False) #cria a nova tabela csv, não incluindo os índices como coluna

