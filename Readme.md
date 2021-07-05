Utilizando os conceitos de CDI crie uma aplicação de conta bancária que permite que um usuário, que possua uma ou várias contas bancárias, possa realizar saques, visualizar o saldo e realizar depositos. Essa aplicação irá permitir que um usuário autenticado possa realizar as operações. Existem regras para os diversos tipos de conta que um usuário possa realizar:

Um saque de uma conta especial deverá levar em conta o saldo + o limite da conta (acrescente 200 reais de limite e 400 de saldo na criação do objeto)

Um depósito em uma conta especial só poderá alterar o saldo se a conta não estiver em crédito (limite < 200)

As operações de saque e deposito de uma conta poupança retiram 0.07% do saldo atual. (Adicione nesta conta um saldo de 100 reais ao criar um objeto);

A aplicação deverá apresentar um menu para as operações de criar um usuário, criar uma conta bancária (especial, normal ou poupança) e realizar as operações de cada uma delas, para um usuário autenticado.