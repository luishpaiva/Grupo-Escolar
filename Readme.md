Projeto da disciplina de Fundamentos da Programa��o Orientada a Objetos

Nesta atividade, equipes de dois a tr�s estudantes dever�o construir uma aplica��o em que sejam empregados os conceitos de persist�ncia de objetos, com utiliza��o de interface gr�fica orientada a evento, heran�a, polimorfismo e tratamento de exce��o.

QUESITOS A SEREM AVALIADOS

1.Modelagem de classes com heran�a, realizada com o aux�lio de ferramenta (PowerPoint ou Word,por exemplo).
	a)Cada equipe deve definir sua organiza��o pr�pria de classes com heran�a, visando a aproveitar osrecursos do polimorfismo.
	b)Com um dom�nio de aplica��o selecionado/definido, a equipe deve adaptar o exemplo dado (PetStore)para o dom�nio de aplica��o escolhido.
	c)Sugest�es de classes poss�veis est�o disponibilizadas no fim deste documento.
2. Polimorfismo entre classes.
	d) Sobrescrita (@override) de m�todos.
	e) Refer�ncias polim�rficas.
	f) Controle de repeti��o usado em cole��o de objetos (ArrayList).
3. Grava��o e recupera��o de objetos em arquivo.
4. Utiliza��o da estrutura switch para controle de menu de op��es.
5. Utiliza��o de tratamento de exce��es para manipula��o de arquivos.

ORIENTA��ES GERAIS

Com base no exemplo (arquivo PetSore.ZIP), as equipes dever�o utilizar os recursos a seguir, como apresentado ou de forma equivalente, desde que todos os componentes da equipe demonstrem conhecimento desses recursos.

Lista
	Usar estrutura de ArrayList para manter em mem�ria, semelhante � utilizada no exemplo com a cole��o de objetos mam�feros de PetStore:

ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();

Menu (no exemplo, para manipula��o das opera��es da PetStore)
	Usar estrutura de controle switch

...
switch (opc1) {
	case 1:// Entrar dados
		...
		break;
	case 2: // Exibir dados
		...
		break;
	case 9:
		JOptionPane.showMessageDialog
		(null,"Fim PET Store");
		break;
	}
...

Sobrescrita (@override)
	Usar no m�todo toString(), aproveitando o m�todo da classe-m�e, por meio da chamada super.
	Usar em m�todos construtores (encadeamento de construtores).

Persist�ncia de objetos: observem os detalhes de implementa��o usados no exemplo.
	Objetos a serem persistidos (armazenados em arquivo) devem implementar a interface. java.io.Serializable
	Grava��o (void salvaProdutos (ArrayList<Mamifero> mamiferos):

	outputStream = new ObjectOutputStream
		(new FileOutputStream(nomeArquivo));

Recupera��o (ArrayList<Mamifero> recuperaProdutos ()):
	inputStream = new ObjectInputStream
		(new FileInputStream(nomeArquivo));

Itens esperados na aplica��o

	1. Cada equipe dever� ter seu conjunto pr�prio de objetos (dom�nio de aplica��o), que dever�o ser persistidos e recuperados, conforme escolha do usu�rio em menu de op��es.
	2. O conjunto de objetos dever� trabalhar a generaliza��o com hierarquia, para aproveitamento das facilidades do polimorfismo (refer�ncia polim�rfica em cole��o de objetos, como ArrayList, para manter cole��es de objetos com as mesmas rela��es hier�rquicas).
	3. A aplica��o dever� utilizar interface gr�fica, conforme exemplificado (arquivo PetSore.ZIP).
	4. A aplica��o dever� ter tratamento de exce��o para acesso a arquivos e para tratamento de demais erros em potencial.
	5. A aplica��o dever� ter tratamento de op��es para o usu�rio via menu.
	6. Utilizar construtores adequadamente: reutilizar o construtor da classe-pai, sempre que poss�vel.
	7. Utilizar getter e setter para prover encapsulamento, sempre que poss�vel.
	8. Utilizar o m�todo toString()para apresentar objetos ao usu�rio.

ORIENTA��O PARA IMPLEMENTA��O DA INTERFACE GR�FICA

Seguir o modelo passado no exemplo da PetStore.

Sequ�ncia de apresenta��o das caixas de di�logo do programa � adaptar o dom�nio de aplica��o escolhido, conforme demonstrado nas telas do exemplo, a seguir.

	a) Entrar os dados de um c�o e de um gato.
	b) Exibir a lista de mam�feros.
	c) Gravar os objetos criados em arquivo.
	d) Limpar da mem�ria (ArrayList) os objetos rec�m-criados.
	e) Exibir novamente a lista de mam�feros.
	f) Recuperar os objetos persistidos.
	g) Exibir novamente a lista de mam�feros.
	h) Sair do programa.

SUGEST�ES DE DOM�NIO DE APLICA��O

Seguem sugest�es para altera��o do dom�nio de aplica��o, para que as equipes alterem o exemplo dado. Caso prefiram, poder�o criar e utilizar seu pr�prio conjunto de objetos, desde que validado com o professor. Importante: garanta que as subclasses tenham mais um ou dois atributos, al�m dos recebidos da heran�a.

Supermercado
	Produto (c�digo, nome, fornecedor, categoria: limpeza, bebida ou latic�nio)
	Limpeza (tipo de limpeza: sab�o, desinfetante, detergente...)
	Bebida (tipo de bebida: refrigerante, vinho, suco...)
	Latic�nio (tipo de latic�nio: queijos, leites, iogurtes...)

Biblioteca
	Livro (nome, ISBN, autor, resenha)
		Livros infantis (brinde: boneco, l�pis de colorir, giz de cera...)
		Livros de culin�ria (tipo de culin�ria: regional, internacional, doces, carnes...)
		Guias de viagem (local: nome de pa�s, nome de regi�o em um pa�s, parques...)

Cl�nica veterin�ria
	Animal (nome, esp�cie, dono)
		Cavalo (alimenta��o: ra��o, aveia, alfafa...; cuidados pr�prios: corrida, trote, cascos...)
		Cachorro (alimenta��o: ra��o, carnes...; cuidados pr�prios: tosa, banho...)
		P�ssaro (alimenta��o: alpiste, frutas...; cuidados pr�prios: abrigo, est�mulos...)

Exames cl�nicos
	Exame (conv�nio, nome do m�dico, nome do paciente)
		Sangue (prepara��o pr�pria: jejum 6h, jejum 8h, rem�dios e bebidas proibidos...)
		Raio X (prepara��o pr�pria: jejum, laxantes...)
		Ecografia (prepara��o pr�pria: jejum, bexiga cheia...)

Grupo escolar
	Estudante (matr�cula, nome, respons�vel)
		Pr�-escolar (cuidados: alergias, rem�dios...)
		Ensino fundamental (atividades de contraturno: nata��o, jud�, gin�stica...)
		Ensino m�dio (oficinas profissionalizantes: computa��o, marcenaria, contabilidade...)

Frota motorizada
	Ve�culo (marca, modelo, ano, quilometragem, placa)
		Autom�vel (motoriza��o: motor 1.0, motor, motor 1.6...)
		Caminh�o (carga m�xima: 16 toneladas, 23 toneladas...)
		�nibus (assentos: 20, 40...)

Delega��o
	Atleta (nome, n�mero)
		Saltador (altura)
		Corredor (velocidade)
		Nadador (estilo)

Loja de eletr�nicos
	Equipamento (nome, marca, modelo, tamanho da tela)
		Smartphone (quantidade de chips de operadora, tamanho da tela)
		Smartwatch (tipo de pulseira: couro, metal...)
		Notebook (processador, mem�ria RAM, disco, tamanho da tela)