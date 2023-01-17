var a = document.getElementById('entree');
var division = document.createElement('div');
division.appendChild(document.createTextNode('Entrez le nombre de ligne  :'));
division.setAttribute('id','ligne');
a.appendChild(division);
var lig1 = document.createElement('input');//nbr lignes
lig1.setAttribute('id','lig1');
lig1.setAttribute('type','number');
lig1.setAttribute('min','0');
lig1.setAttribute('max','4');
division.appendChild(lig1);
division.appendChild(document.createElement('br'));
division.appendChild(document.createTextNode('Entrez le nombre de colonne :'));
var col1 = document.createElement('input');//nbr colonnes
col1.setAttribute('id','col1');
col1.setAttribute('type','number');
col1.setAttribute('min','0');
col1.setAttribute('max','4');
division.appendChild(col1);
division.appendChild(document.createElement('br'));
var butt = document.createElement('button');

var t=0;
butt.onclick = function() {
	t = 0;
	try {
		eval(lig1.value);
	}catch(e){
		if (e instanceof ReferenceError)
		{
			lig1.value="";
			lig1.setAttribute('class','vide');
			lig1.setAttribute('placeholder','Null');
			t = 1;
		}
	}
	if(Number.isInteger(eval(lig1.value)) == 0 || eval(lig1.value) <= 0 )
	{

		lig1.setAttribute('class','vide');
		lig1.value="";
		lig1.setAttribute('placeholder','Null');
		t = 1;
	}
	try {
		eval(col1.value);
	}catch(e){
		if (e instanceof ReferenceError)
		{
			col1.value="";
			col1.setAttribute('class','vide');
			col1.setAttribute('placeholder','Null');
			t = 1;
		}
	}
	if(Number.isInteger(eval(col1.value)) == 0 || eval(col1.value) <= 0 )
	{

		col1.setAttribute('class','vide');
		col1.value="";
		col1.setAttribute('placeholder','Null');
		t = 1;
	}
	if(t==1)
		return (1);
	matrix(lig1.value,col1.value);	
    };
butt.appendChild(document.createTextNode("calculer"));
butt.setAttribute('type','submit');
butt.setAttribute('class',"btn btn-success mb-2");
division.appendChild(butt);