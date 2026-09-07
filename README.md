
# Projeto Lactus (Android/Kotlin)

## Equipe: Lactus

**Integrantes:**
- Enzo Demitrius Carvalhaes - RM: 558912
- Luciano Henrique Gonçalves D'Oliveira - RM: 558975
- Matheus Rocha Sousa - RM: 559201
- Rafael Vitor de Almeida - RM: 559116
- Vitor Silva Batista - RM: 558865

---

## Objetivo do Aplicativo
O **Lactus** é uma plataforma desenvolvida em parceria acadêmica (FIAP e Eurofarma) para solucionar um problema crítico de saúde pública: o déficit nas doações de leite humano. Atualmente, cerca de 330 mil bebês prematuros nascem por ano no Brasil (11% da população), mas apenas 45% da demanda por leite materno é atendida.

O problema central não é a falta de vontade de doar, mas sim a comunicação e o engajamento limitados que dificultam o alcance a potenciais nutrizes. Diante disso, o objetivo do aplicativo é criar um canal de comunicação de "zero atrito". O Lactus visa conectar de forma eficiente as mães doadoras à infraestrutura já existente de 222 bancos de leite e 217 postos de coleta espalhados pelo território brasileiro.

---

## Repositório GitHub
[Link para o repositório do projeto no GitHub](https://github.com/mrsMatheusRocha/Lactus-Kotlin/)

---

## Telas do Aplicativo
> As imagens apresentadas abaixo são prints **reais** do aplicativo rodando nativamente no (Emulador do Android Studio / Dispositivo Físico), cumprindo os requisitos de entrega.

### 1. Tela de Login
<img width="300" alt="Tela Login" src="https://github.com/user-attachments/assets/60f78c78-2229-40ec-b558-6b3c20d488a0" />
**Descrição:** Tela inicial do aplicativo onde o usuário insere seu e-mail e senha para acesso. Conta com validação visual de campos obrigatórios e tratamento de erros para credenciais incorretas

---

### 2. Tela Principal (Home)
https://github.com/user-attachments/assets/09c91469-8f54-4d67-adb5-7f46423030fe

**Descrição:** Atua como o portal central de boas-vindas e engajamento da nutriz, projetado com o conceito de "zero atrito". A tela disponibiliza um atalho imediato para o atendimento via WhatsApp, exibe uma lista geolocalizada de bancos de leite próximos e apresenta a "Lia", uma assistente de inteligência artificial integrada focada em tirar dúvidas sobre ordenha, oferecer apoio emocional e agendar coletas em domicílio de forma simplificada.

---

### 3. Tela do Gestor (Dashboard)
https://github.com/user-attachments/assets/f0722018-c229-40c4-9c46-1ed7b521317f

**Descrição:** Apresenta um painel de controle (dashboard) com métricas estratégicas para os administradores e gestores de bancos de leite. Permite visualizar rapidamente dados fundamentais, como o volume de leite humano arrecadado, o engajamento de nutrizes cadastradas e o status das coletas agendadas.

---

### 4. Tela da Nutriz (Cadastro)
https://github.com/user-attachments/assets/aab295a5-4cd4-4dd2-81a4-c71c5893eb4a

**Descrição:** Apresenta um formulário simplificado para o registro inicial de novas doadoras. Permite a coleta de informações essenciais da nutriz de maneira rápida e intuitiva, com foco em reduzir o atrito e facilitar o ingresso no programa de doação.

---

### 4. Tela de Login (Erro)
<img width="300" style="margin: 5px" alt="Tela Login Erro" src="https://github.com/user-attachments/assets/662ea906-a158-457d-8d81-b8c08c50cb0c" />

**Descrição:** Apresenta a tela de login com o tratamento visual de erro para credenciais inválidas. Exibe um feedback imediato e claro em vermelho ("Dados incorretos. Verifique seu e-mail e senha.") quando a usuária tenta acessar a plataforma com informações não cadastradas, orientando a correção de forma direta sem que a nutriz perca o contexto da navegação.

---

## Dados Mockados Utilizados
Nesta etapa do desenvolvimento, como não há conexão com um backend definitivo, utilizamos dados estáticos (mockados) para simular o comportamento de uma API real. Foram implementados os seguintes mocks:
* **Autenticação:** Foi criado um usuário fixo (`gestor@lactus.com` / senha: `123456`) para simular o processo de verificação de login.
* **Listagens:** Criamos uma lista estática de objetos (ex: histórico de litros de leite, perfil das doadoras) populada diretamente nas classes do projeto para renderizar a interface de forma realista.
* **Estatísticas da Home:** Os números e métricas exibidos no dashboard são valores gerados de forma fixa no código, demonstrando como a UI irá reagir aos dados quando o banco de dados real estiver integrado.

---

## Funcionalidades Implementadas
* Autenticação simulada com feedback visual.
* Navegação fluida entre telas utilizando o sistema de navegação nativo (Intents / Navigation Component).
* Exibição de listas dinâmicas com `RecyclerView` (ou `LazyColumn` do Compose).
* Interface responsiva adaptada para diferentes tamanhos de tela e modo claro/escuro.
* Componentes visuais personalizados baseados no Material Design.

---

## Tecnologias Utilizadas
* **Linguagem:** Kotlin
* **IDE:** Android Studio
* **Construção de UI:** [XML Clássico / Jetpack Compose]
* **Arquitetura (Padrão de Projeto):** [MVVM / MVC]
* **Controle de Versão:** Git & GitHub
* **Bibliotecas Adicionais:** 
  * **Jetpack Compose (Core, UI & Material 3):** Conjunto de bibliotecas nativas (`androidx.compose.*`) utilizadas como base estrutural para a criação de uma interface gráfica moderna, reativa e baseada nos padrões do Material Design 3.
  * **Navigation Compose** (`androidx.navigation:navigation-compose`): Utilizada para o gerenciamento de rotas, passagem de parâmetros e navegação fluida entre as telas do aplicativo.
  * **Material Icons Extended** (`androidx.compose.material:material-icons-extended`): Utilizada para fornecer acesso à biblioteca completa de ícones do Material Design.

---

## Instruções Básicas para Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. **Abra o projeto no Android Studio:**
   * Inicie o Android Studio.
   * Selecione `File > Open` e navegue até a pasta raiz do projeto clonado.
3. **Sincronize o Gradle:**
   * Aguarde o Android Studio baixar as dependências necessárias. Se solicitado, clique no ícone do elefante para sincronizar o projeto com os arquivos do Gradle (`Sync Project with Gradle Files`).
4. **Execute o aplicativo:**
   * Conecte um dispositivo Android físico (com depuração USB ativada) ou inicie um Emulador (AVD Manager).
   * Clique no botão verde **Run 'app' (▶️)** na barra de ferramentas superior.
   * O aplicativo será compilado, instalado e executado no dispositivo.
