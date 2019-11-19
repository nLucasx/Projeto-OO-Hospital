# Projeto de Software
## Aluno: Lucas Buarque de Araujo Barros

#### Sistema de Gerenciamento de Clínica
   O objetivo do projeto é criar um sistema para gerenciar uma clínica. O dono de uma clínica solicitou um sistema que o auxiliasse na organização da mesma da seguinte maneira: </br>
   O sistema será dividido em camadas. Desde o administrador da clínica até os funcionários poderão utilizar o sistema, porém cada um irá acessar sua respectiva camada referente à sua área de trabalho. Cada camada terá sua forma de Login no sistema, os médicos irão acessá-lo utilizando o seu CPF e CRM e os demais terão um usuário e senha padronizados.

# Administrador
   Esta camada será a que o dono da clínica irá se conectar. Seguem as funcionalidades disponíveis ao administrador:
   * Cadastro de funcionários </br>
   Quando o gerente da clínica contratar um funcionário, ele poderá registrá-lo em um banco de dados que armazena os funcionários que trabalham na clínica com todas as suas informações. O sistema dará a opção de registrar médicos, enfermeiros, recepcionistas e auxiliares de serviços gerais. De acordo com a área de atuação do funcionário, serão pedidos diferentes tipos de dados sobre ele, como o CRM do médico, por exemplo. </br> </br>
   * Pagamento de funcionários </br>
   Esta funcionalidade será usada para a gestão financeira da clínica. Quando o gerente utilizar esta funcionalidade, ele terá acesso ao saldo da clínica e poderá efetuar os devidos pagamentos aos funcionários da clínica. O saldo será atualizado automaticamente logo após o pagamento ter sido efetuado. Caso não haja saldo disponível, o gerente deverá registrar mais saldo disponível. </br>
   * Exclusão de um funcionário do banco de dados </br>
   Esta funcionalidade será usada quando ocorrer a demissão de um funcionário da clinica. O gerente precisará excluir aquele funcionário do banco de dados para saber que ele não trabalha mais em sua clínica. </br>
   * Busca de funcionário no banco de dados da clínica </br>
   Através do CPF, o gerente poderá verificar todas as informações disponíveis sobre um funcionário. Caso o CPF não estiver cadastrado, o sistema irá informá-lo. </br> 
   * Registro de compra de materiais </br>
   Esta funcionalidade tem o objetivo de gerenciar a quantidade de materiais disponíveis na clínica, sejam eles materiais hospitalares, limpeza e etc. Os materiais serão listados em categorias de uso e em ordem decrescente de unidades. O sistema já disponibilizará uma lista padrão de materiais necessários na clínica. O administrador poderá adicionar um novo material específico na lista </br>
   * Registro de uso de materiais </br>
   Em contrapartida, esta funcionalidade terá o objetivo registrar o uso de unidades disponíveis de materiais. Quando o número de unidades de um certo material chegar a zero, o gerente já saberá da necessidade de comprar mais unidades daquele material.
Funcionalidades:</br>
   * Listagem de materiais disponíveis </br>
   Esta opção será para a verificação de unidades disponíveis de materiais na clínica. Caso algum material esteja em falta, será mostrado "Em falta!" ao lado do mesmo. Essa funcionalidade é bastante importante na gestão da clínica. </br>

1 - Cadastrar funcionários </br>
Médicos, enfermeiros, recepcionistas e serviço geral.</br>
2 - Agendamento de consulta</br>
Uma pessoa poderá pedir  para agendar uma consulta.</br>
3 - Gerar relatório médico</br>
Será possível gerar um relatório sobre o paciente consultado, com o objetivo de analisar o andamento do mesmo.</br>
4 - Triagem</br>
Um paciente poderá escolher ser atendido pela emergência. Ele precisará fazer a triagem para verificarmos qual é a prioridade de atendimento.</br>
5 - Chamar um paciente para ser atendido</br>
Se um paciente quiser entrar na fila de espera da emergência, em algum momento o recepcionista poderá utilizar essa funcionalidade para mostrar quem será atendendido naquele momento.</br>
 6 - Pagamento dos funcionários</br>
O dono da clínica poderá automaticamente pagar seus funcionários de acordo com o saldo da clínica. Ele irá configurar quanto de saldo está disponível naquele momento.</br>
7 - Registrar materiais comprados.</br>
O dono da clínica poderá registrar novos materiais  necessários no uso diário que serão comprados.</br>
8 - Registrar uso de algum material</br>
Qualquer funcionário da clínica poderá utilizar os materiais diariamente em seu trabalho, porém o dono da clínica deverá registrar o uso dos mesmos.</br>
9 - Demitir funcionários</br>
O dono da clínica poderá demitir funcionários.</br>
10 - Login</br>
Cada funcionário terá uma conta que poderá fazer login. Algumas funcionalidades serão restritas dependendo do tipo de usuário.</br>
