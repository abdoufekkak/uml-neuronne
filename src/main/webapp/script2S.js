function matrixS(ligne,colonne)
{
  var i = 0;
  var j = 0;
  var matrixS = document.getElementById('matrixS');
  var table2 = document.createElement('table');
  var b2 = document.createElement('button'); 

  var a2 = document.getElementById('sortie');
  a2.removeChild(document.getElementById('col'));

  b2.appendChild(document.createTextNode("valider"));
  b2.setAttribute('type','submit');
  b2.setAttribute('class',"btn btn-success mb-2");
  a2.appendChild(b2);
  matrixS.appendChild(table2);

  
  while(i < ligne){
    var tr = document.createElement('tr');
    j=0;
    while(j < colonne){
        var td = document.createElement('td');
        var input = document.createElement('input');
        input.setAttribute('name','y'+i+j);
        td.appendChild(input);
        tr.appendChild(td);
    j++;
  }
  i++;
  table2.appendChild(tr);
  }

}