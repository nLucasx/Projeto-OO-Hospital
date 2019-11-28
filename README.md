# Projeto de Software
## Aluno: Lucas Buarque de Araujo Barros

#### Sistema de Gerenciamento de Clínica
   O objetivo do projeto é criar um sistema para gerenciar uma clínica. O dono de uma clínica solicitou um sistema que o auxiliasse na organização da mesma da seguinte maneira: </br>
   O sistema será dividido em camadas. Desde o administrador da clínica até os funcionários poderão utilizar o sistema, porém cada um irá acessar sua respectiva camada referente à sua área de trabalho. Cada camada terá sua forma de Login no sistema, os médicos irão acessá-lo utilizando o seu CPF e CRM e os demais terão um usuário e senha padronizados. O Login será uma funcionalidade geral do sistema.

# Administrador
   Esta camada será a que o gerente da clínica irá se conectar. Seguem as funcionalidades disponíveis ao administrador:
   * Cadastro de funcionários </br>
   Quando o gerente da clínica contratar um funcionário, ele poderá registrá-lo em um banco de dados que armazena os funcionários que trabalham na clínica com todas as suas informações. O sistema dará a opção de registrar médicos, enfermeiros, recepcionistas e auxiliares de serviços gerais. De acordo com a área de atuação do funcionário, serão pedidos diferentes tipos de dados sobre ele, como o CRM do médico, por exemplo. </br> </br>
   * Pagamento de funcionários </br>
   Esta funcionalidade será usada para a gestão financeira da clínica. Quando o gerente utilizar esta funcionalidade, ele terá acesso ao saldo da clínica e poderá efetuar os devidos pagamentos aos funcionários da clínica. O saldo será atualizado automaticamente logo após o pagamento ter sido efetuado. Caso não haja saldo disponível, o gerente deverá registrar mais saldo disponível. </br></br>
   * Exclusão de um funcionário do banco de dados </br>
   Esta funcionalidade será usada quando ocorrer a demissão de um funcionário da clinica. O gerente precisará excluir aquele funcionário do banco de dados para saber que ele não trabalha mais em sua clínica. </br></br>
   * Busca de funcionário no banco de dados da clínica </br>
   Através do CPF, o gerente poderá verificar todas as informações disponíveis sobre um funcionário. Caso o CPF não estiver cadastrado, o sistema irá informá-lo. </br></br>
   * Registro de compra de materiais </br>
   Esta funcionalidade tem o objetivo de gerenciar a quantidade de materiais disponíveis na clínica, sejam eles materiais hospitalares ou limpeza. Os materiais serão listados em categorias de uso e em ordem crescente de unidades. O sistema já disponibilizará uma lista padrão de materiais necessários na clínica. O administrador poderá adicionar um novo material específico na lista </br></br>
   * Registro de uso de materiais </br>
   Esta funcionalidade terá o objetivo registrar o uso de unidades disponíveis de materiais. Quando o número de unidades de um certo material chegar a zero, o gerente já saberá da necessidade de comprar mais unidades daquele material.</br></br>
   * Listagem de materiais disponíveis </br>
   Esta opção será para a verificação de unidades disponíveis de materiais na clínica. Caso algum material esteja em falta, será mostrado "Em falta!" ao lado do mesmo. Essa funcionalidade é bastante importante na gestão da clínica. </br></br>

# Médico
   Esta camada será a que os médicos irão se conectar. Seguem as funcionalidades disponíveis aos médicos: 
   * Login específico </br>
   Diferentemente das outras camadas do sistema que serão acessadas apenas com um usuário e senha, cada médico poderá acessar uma conta privada na qual estarão as informações sobre os pacientes atendidos e cada relatório médico referente aos mesmos. </br></br>
   
   * Atender paciente </br>
   Nesta funcionalidade, o médico irá atender o paciente que a recepção acabou de chamar. Após o termino da consulta será gerado o relatório médico sobre o paciente atendido. </br></br>
   * Informar disponibilidade </br>
   Após o termino da consulta, essa funcionalidade irá entrar em contato com a recepção para informá-la que o médico está sem nenhum paciente em sua sala, o que significa que o próximo paciente poderá ser chamado para ser consultado. </br></br>
   * Gerar relatório médico </br>
   Esta funcionalidade será utilizada pelo médico para registrar o andamento da consulta com cada paciente. No relatório estarão todas as informações sobre o paciente e a descrição da queixa coletada no processo de anamnese. A cada consulta feita, o médico precisará registrar um relatório obrigatoriamente. </br></br>
   * Listagem de pacientes atendidos </br>
   O médico utilizará essa funcionalidade para verificar quais são os pacientes que foram atendidos por ele para facilitar na busca de qualquer relatório futuramente.</br></br>
   * Busca de relatório médico </br>
   Esta funcionalidade será utilizada para a leitura de um relatório médico existente no sistema. Para buscar um relatório específico, basta informar o CPF do paciente que poderá ser consultado utilizando a funcionalidade "Listagem de pacientes".</br></br>

# Recepção
   Esta camada será a que a recepção irá se conectar. Seguem as funcionalidades disponíveis à recepção:
   * Agendamento de consulta</br>
   Nesta funcionalidade, a pessoa informará seus dados à recepção e se quer ser atendida pela emergência ou por um médico específico disponível. Caso a pessoa escolha a emergência, a recepção irá encaminhá-la para o processo de triagem que será feito pela enfermaria. </br></br>
   * Verificar listas de espera </br>
   Caso alguma pessoa queira saber sua posição na lista de espera, ela poderá pedir para a recepção informá-la. Será mostrada a lista de espera referente ao médico que a pessoa irá ser consultada. </br></br>
   * Chamar um paciente para ser atendido</br> 
   Nesta funcionalidade, a recepção irá retirar o paciente da fila de espera e o chamará através de um alerta emitido pelo sistema. A recepção só poderá chamar o paciente para ser atendido quando o médico estiver sem nenhuma consulta em andamento. </br></br>
# Enfermaria
   Esta camada será a que a enfermaria irá se conectar. Segue a funcionalidade disponível à enfermaria:
   * Triagem </br>
   Um paciente poderá escolher ser atendido pela emergência. Ele precisará fazer a triagem para ser verificada a prioridade de atendimento. Esta funcionalidade organizará a lista de espera da emergência. Caso existam prioridades iguais na lista de espera, o critério de desempate será a idade (quanto maior a idade, maior prioridade). Se existirem prioridades iguais e idades iguais, permanece na frente quem chegou primeiro na lista. </br></br>
 
 Login Admin:
 user : admin
 password : admin </br>
 
 
 Login Recepção:
 user : recep
 password : recep </br>
 
 
 Login Enfermaria:
 user : nursery
 password : nursery </br>
 
