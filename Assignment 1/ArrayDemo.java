package ArraysLoopsMemoryMaps;

public class ArrayDemo {
	
	public void demonstrateTask1(){
		System.out.println("Demonstrate	Task	1");
		
		int[]	numbers =	null;	//	note	that	numbers	references	nothing	(null)	initially
		numbers	=	new int[5]; //	a	reference	to	an Array	object	containing	int values	is	assigned
		
		System.out.println("Array	of	primitives	before	assigning	values");
		//	TODO:	loop	to	print	the	values	in	the	array	elements	on	one	line	separated	by	spaces
		int i;
		for(i=0;i<5;i++)
			System.out.print(numbers[i]+" ");
		
		//	TODO:	loop to	assign	values	1	to	5	into	the	array	elements
		for(i=0;i<5;i++)
			numbers[i] = i+1;
		
		System.out.println("\nArray	of	primitives	after	assigning	values");
		//	TODO:	loop	to	again	print	the	values	on	one	line	separated	by	spaces
		for(i=0;i<5;i++)
			System.out.print(numbers[i]+" ");
		//	TODO:	Draw	a	memory	map	for	int[] numbers =	new int[5];	at	this	point
	}

	public void demonstrateTask2(){
			System.out.println("\n\nDemonstrate	Task	2");
			
			Goldfish[]	fishes =	new Goldfish[5];
			
			System.out.println("\nArray of	references	before	assigning	references");	
			int i;
			//	TODO:	loop	to	print	the	reference	value	within	each	array	element	separated	by	a	space	
			for(i=0;i<fishes.length;i++)
				System.out.print(fishes[i] + " ");
			
			//	TODO:	loop	to	initialize	each	array	element	with	a	Goldfish	object,	each	with
			//	weights of	1,	2,	3,	4,	5	
			double k=1.0;
			for(i=0;i<fishes.length;i++){
				fishes[i] = new Goldfish();
				fishes[i].setWeight(k++);
			}
			
			System.out.println("\nArray	of	references	after	assigning	references	to	Goldfish");
			//	TODO:	loop	to	print	the	each	referenced	objects	weight	separated	by	a	space
			for(i=0;i<fishes.length;i++)
				System.out.print(fishes[i].getWeight() + " ");
			
			//	TODO:	Draw	a	memory	map	for	Goldfish[] fishes	=	new	Goldfish[5];	at	this	point
	}
	
	public void demonstrateTask3(){
			System.out.println("\nDemonstrate	Task	3");
			
			int[][]	numbers =	new int[5][5];
			
			System.out.println("\n2D	Array	of	primitives	before	assigning	values");
			//	TODO:	use	nested	loops	to	display	the	25	default	int	values	in	the	array	elements,
			//	5	per	row,	5	rows	separated	by	spaces (Tip:	Put	a	println	within	the	outer	loop
			//	below	the	inner	loop)
			int i, j;
			for(j=0;j<5;j++){
				for(i=0;i<5;i++)
					System.out.print(numbers[j][i] + " ");
				System.out.println();
			}
			
			//	TODO:	use	nested	loops	to	initialize	each	element	with	the	multiplication	of
			//	the	loop	couters	+	1,	e.g.	element[0][0]	should	have	a	value	of	1,	element[4][4]	
			//	should	have	a	value	of	25
			for(j=0;j<5;j++){
				for(i=0;i<5;i++)
					numbers[j][i] = (i+1)*(j+1);
			}
			
			System.out.println("\n2D	Array	of	primitives	after	assigning	values");
			//	TODO:	use	nested	loops	to	display	the	25	default	int	values	in	the	array	elements,
			//	5	per	row,	5	rows	separated	by	spaces
			for(j=0;j<5;j++){
				for(i=0;i<5;i++)
					System.out.print(numbers[j][i] + " ");
				System.out.println();
			}
			
			//	TODO:	Draw	a	memory	map	for	int[][]	numbers =	new int[5][5];	at	this	point
	}
	
	//	BONUS	(4)	for	this	exercise.	2	points	for	code,	2	points	for	correct	memory	map.
	//	Note:	Task	4	leads	into	Assignment	1,	the	Battlefield	that	uses	a	2D	array	of	references
	//							to	objects	instantiated	from	class	Square.
	public void demonstrateTask4(){
			
			System.out.println("Demonstrate	Task	4");
			
			Goldfish[][]	fishes =	new Goldfish[5][5];
			
			System.out.println("\n2D	Array	of	references	before	assigning	references");
			//	TODO:	use nested	loops	to	display	the	25	default	reference	values	in	the	array
			// elements, 5	per	row,	5	rows	separated	by	spaces
			int i, j;
			for(j=0;j<5;j++){
				for(i=0;i<5;i++)
					System.out.print(fishes[j][i] + " ");
				System.out.println();
			}
			
			//	TODO:	use	nested	loops	to	store	a	reference	to	25	Goldfish	objects,	each	one	with	a
			// weight set to	be	the	multiplication	of	the	loop	counters	+	1,	for	example	the	Goldfish
			// object	 referenced	by	element[0][0]	would	have	a	weight	of	1,	while	the	Goldfish	object
			// referenced	by	element[4][4]	would	have	a	weight	of	25.
			for(j=0;j<5;j++){
				for(i=0;i<5;i++){
					fishes[j][i] = new Goldfish();
					fishes[j][i].setWeight((i+1)*(j+1));
				}
			}
			
			System.out.println("\n2D	Array	of	references	after	assigning	references to	Goldfish");
			//	TODO:	use	nested	loops	to	display	the	weight	of	the	25	referenced	Goldfish	objects,
			//	5	per	row,	5	rows	separated	by	spaces.
			for(j=0;j<5;j++){
				for(i=0;i<5;i++)
					System.out.print(fishes[j][i].getWeight() + " ");
				System.out.println();
			}
			
			//	Draw	a	memory	map	for	Goldfish[][]	fishes	=	new Goldfish[5][5]; at	this	point
	}
}
