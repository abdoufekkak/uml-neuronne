var a2 = document.getElementById('sortie');
var division2 = document.createElement('div');
division2.appendChild(document.createTextNode('Entrez le nombre de ligne  :'));
division2.setAttribute('id','col');
a2.appendChild(division2);
var lig2 = document.createElement('input');//nbr lignes
lig2.setAttribute('id','lig2');
lig2.setAttribute('type','number');
lig2.setAttribute('min','0');
lig2.setAttribute('max','4');
division2.appendChild(lig2);
division2.appendChild(document.createElement('br'));
division2.appendChild(document.createTextNode('Entrez le nombre de colonne :'));
var col2 = document.createElement('input');//nbr colonnes
col2.setAttribute('id','col2');
col2.setAttribute('type','number');
col2.setAttribute('min','0');
col2.setAttribute('max','4');
division2.appendChild(col2);
division2.appendChild(document.createElement('br'));
var butt2 = document.createElement('button');

var t2=0;
butt2.onclick = function() {
	t2 = 0;
	try {
		eval(lig2.value);
	}catch(e){
		if (e instanceof ReferenceError)
		{
			lig2.value="";
			lig2.setAttribute('class','vide');
			lig2.setAttribute('placeholder','Null');
			t2 = 1;
		}
	}
	if(Number.isInteger(eval(lig2.value)) == 0 || eval(lig2.value) <= 0 )
	{

		lig2.setAttribute('class','vide');
		lig2.value="";
		lig2.setAttribute('placeholder','Null');
		t2 = 1;
	}
	try {
		eval(col2.value);
	}catch(e){
		if (e instanceof ReferenceError)
		{
			col2.value="";
			col2.setAttribute('class','vide');
			col2.setAttribute('placeholder','Null');
			t2 = 1;
		}
	}
	if(Number.isInteger(eval(col2.value)) == 0 || eval(col2.value) <= 0 )
	{

		col2.setAttribute('class','vide');
		col2.value="";
		col2.setAttribute('placeholder','Null');
		t2 = 1;
	}
	if(t2==1)
		return (1);
	matrixS(lig2.value,col2.value);	
    };
butt2.appendChild(document.createTextNode("calculer"));
butt2.setAttribute('type','submit');
butt2.setAttribute('class',"btn btn-success mb-2");
division2.appendChild(butt2);