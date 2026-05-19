🌱 PlantUp

O PlantUp é um aplicativo mobile desenvolvido em Kotlin com Jetpack Compose, criado para auxiliar usuários no cuidado diário com plantas. 
O objetivo principal do app é facilitar a organização de tarefas como rega, adubação e outros cuidados essenciais, ajudando o usuário a manter suas plantas saudáveis de forma prática e intuitiva.

Funcionalidades: O aplicativo permite que o usuário crie e gerencie lembretes personalizados de cuidado com plantas, além de editar tarefas já existentes sempre que necessário. A interface também conta com uma tela inicial que centraliza o acesso às principais funções, proporcionando uma navegação mais rápida e eficiente. 
Além disso, o PlantUp oferece uma seção de dicas com orientações sobre cuidados com plantas, uma tela de informações sobre o aplicativo e um perfil de usuário. Toda a navegação é organizada por meio de um menu lateral (Navigation Drawer), garantindo uma experiência mais fluida.

Navegação: A navegação do aplicativo foi construída utilizando Jetpack Navigation Compose, com o apoio de um ModalNavigationDrawer para acesso ao menu lateral. As rotas são centralizadas para facilitar a manutenção e organização do fluxo de telas.
Entre as principais rotas estão a tela inicial, a criação de novos lembretes, a edição de lembretes específicos através de parâmetros dinâmicos, além das telas de dicas, informações e perfil do usuário. Essa estrutura garante um fluxo consistente e fácil de expandir.

Arquitetura: O projeto segue o padrão MVVM (Model-View-ViewModel), separando claramente responsabilidades entre interface, lógica de estado e gerenciamento de dados. As telas são desenvolvidas com Jetpack Compose, enquanto o ViewModel é responsável por controlar e armazenar os dados dos lembretes por meio do ReminderViewModel.
Essa separação torna o código mais organizado, facilita a manutenção e permite escalabilidade do projeto sem comprometer a estrutura.

Como executar o projeto: Para executar o PlantUp, basta clonar o repositório e abrir o projeto no Android Studio. Após a sincronização das dependências do Gradle, o aplicativo pode ser executado em um emulador ou dispositivo físico com Android.

O projeto foi desenvolvido por Daniel Cunha, com foco em aprendizado prático de desenvolvimento Android moderno utilizando Jetpack Compose, arquitetura MVVM e boas práticas de organização de código.
