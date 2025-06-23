Sistema Bancário Simples em Java
Um projeto de console simples, desenvolvido em Java, que simula as operações básicas de um sistema bancário. O projeto foi criado como um exercício prático para aplicar conceitos de Programação Orientada a Objetos (POO), manipulação de arquivos e estrutura de pacotes.

📋 Índice
Sobre o Projeto
🚀 Funcionalidades
🛠️ Tecnologias Utilizadas
⚙️ Como Começar
Pré-requisitos
Instalação
▶️ Uso
📂 Estrutura do Projeto
📝 Licença
📫 Contato
📖 Sobre o Projeto
Este sistema bancário permite que os usuários criem uma conta, façam login, realizem transferências de saldo, solicitem cartões de crédito ou débito e consultem os dados do cartão. Todas as informações das contas são salvas localmente em um arquivo cadastros.json, garantindo a persistência dos dados entre as execuções do programa.

O projeto foi estruturado seguindo uma variação do padrão MVC (Model-View-Controller) para organizar o código de forma clara e coesa.

🚀 Funcionalidades
[x] Criação de Conta: Cadastro de novos usuários com nome, senha, idade, CPF, CEP, telefone e e-mail.
[x] Autenticação: Login seguro de usuários usando CPF e senha.
[x] Transferência de Saldo: Envio de valores entre contas cadastradas.
[x] Solicitação de Cartão: Geração de cartões de débito ou crédito vinculados à conta.
[x] Visualização de Dados: Exibição dos dados do cartão solicitado (número, validade, CVV).
[x] Validações: Verificação de idade, formato de CPF, e-mail e telefone.
[x] Persistência de Dados: As contas são salvas em um arquivo JSON para manter os dados.
🛠️ Tecnologias Utilizadas
Java: Linguagem principal do projeto.
Google Gson: Biblioteca para serializar e desserializar objetos Java para o formato JSON.
⚙️ Como Começar
Siga estas instruções para obter uma cópia do projeto e executá-lo em sua máquina local.

Pré-requisitos
JDK (Java Development Kit) - Versão 11 ou superior.
IDE de sua preferência - (ex: IntelliJ IDEA, Eclipse, VS Code).
Instalação
Clone o repositório:

Bash

git clone https://github.com/LeonardoRibSouza/sistema-bancario-simples.git
Abra o projeto na sua IDE.

Adicione a biblioteca Gson ao projeto:
O projeto depende da biblioteca Gson. Você precisa adicioná-la ao seu build path.

Faça o download do arquivo .jar mais recente do Gson neste link.
No IntelliJ IDEA (exemplo):
Vá em File > Project Structure....
Selecione Modules na barra lateral.
Clique na aba Dependencies.
Clique no ícone + e selecione JARs or directories....
Navegue até o local onde você salvou o arquivo gson-2.10.1.jar e selecione-o.
Clique em OK para salvar as alterações.
▶️ Uso
Após a instalação e configuração, a aplicação pode ser executada diretamente pela sua IDE:

Encontre o arquivo SistemaBancarioSimples.java.
Clique com o botão direito sobre ele e selecione a opção "Run 'SistemaBancarioSimples.main()'".
O menu do sistema bancário aparecerá no console.
📂 Estrutura do Projeto
O código-fonte está organizado em pacotes que separam as responsabilidades:

src/
├── controller/-# Contém a lógica de negócio (BancoController)

├── exception/-# Classes para visualização de erros

├── model/-# Classes de domínio (Conta, Cartao)

├── save/-# Classe para manipulação de arquivos (ArquivarUtil)

├── util/- # Classes de utilidades (VerificadorUtil, CartaoUtil)

├── view/-# Classes de interação com o usuário

│   ├── menus/

│   └── questions/

└── SistemaBancarioSimples.java-# Ponto de entrada da aplicação
