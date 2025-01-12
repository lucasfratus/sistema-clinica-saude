# Sistema de Gerenciamento de Clínica Médica

Este projeto foi desenvolvido como parte do trabalho avaliativo da disciplina de **Programação Orientada a Objetos**, no primeiro semestre do segundo ano do curso de **Ciência da Computação** da **Universidade Estadual de Maringá (UEM)**, em 2024. 

O objetivo do sistema é simular um ambiente de gestão para uma clínica médica, proporcionando funcionalidades que otimizem o fluxo de informações e o gerenciamento de dados relacionados a pacientes, consultas e prontuários. Ele também visa reforçar conceitos fundamentais de Programação Orientada a Objetos, como encapsulamento, herança, polimorfismo e persistência de dados.


## 📋 Funcionalidades Principais

- **Cadastro de Pacientes**: Gerenciamento de informações básicas e médicas de pacientes.
- **Gerenciamento de Consultas**: Agendamento, atualização e cancelamento de consultas.
- **Prontuários Médicos**: Criação, atualização e exclusão de prontuários.
- **Relatórios Médicos**: Geração de relatórios detalhados sobre pacientes.
- **Interface Gráfica (GUI)**: Interação amigável com o usuário.
- **Persistência de Dados**: Integração com banco de dados para armazenamento e recuperação de informações.

## 🗂 Estrutura do Projeto

O projeto é dividido em diferentes pacotes, cada um responsável por uma parte específica do sistema:

1. **Pacote Atendimento**:
   - `Consulta`: Gerencia informações relacionadas a consultas médicas.
   - `Paciente`: Representa os dados dos pacientes.

2. **Pacote Fichas**:
   - `Prontuario`: Gerencia sintomas, diagnósticos e tratamentos dos pacientes.
   - `RelatoriosMedicos`: Armazena receitas, atestados e declarações de acompanhamento.

3. **Pacote Sistema**:
   - Classes relacionadas ao gerenciamento de entidades como médicos, pacientes e secretárias.

4. **Pacote EmpregadosClinica**:
   - `Medico`: Métodos para gerenciar informações médicas dos pacientes.
   - `Secretaria`: Gerencia pacientes, consultas e relatórios.

5. **Pacote Menu (Interface)**:
   - Classes responsáveis pela interface gráfica para médicos, secretárias e administradores.

## 💻 Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **JPA (Java Persistence API)**: Para a integração com o banco de dados.
- **GUI (Swing)**: Para desenvolvimento da interface gráfica.
- **Banco de Dados**: Persistência de informações (configuração no arquivo `persistence.xml`).

## 🚀 Como Executar

1. **Pré-requisitos**:
   - JDK 8 ou superior.
   - IDE de sua preferência (Eclipse, IntelliJ, etc.).
   - Banco de dados configurado (especificado no arquivo `persistence.xml`).

2. **Passos**:
   - Clone o repositório.
   - Importe o projeto em sua IDE.
   - Configure a conexão com o banco de dados.
   - Execute a classe `Sistema.SistemaBd`.

## 📄 Licença

Este projeto foi desenvolvido como parte de uma avaliação na disciplina de Programação Orientada a Objetos na Universidade Estadual de Maringá e não possui uma licença específica para uso público.

---

Desenvolvido por:
- Giovani Oliveira Santos
- Lucas de Oliveira Fratus
- Mateus Scarpin Ribeiro
- Sérgio de Almeida Cézar
