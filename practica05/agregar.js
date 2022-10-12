function leer() {
    return document.getElementById("todo").value
}
function agregar() {
    nodo = document.createElement("li")
    //texto = document.createTextNode("Hola")
    texto = document.createTextNode(leer())
    console.log(texto)
    nodo.appendChild(texto)
    nodo.setAttribute("id",leer())
    document.getElementById("lista").appendChild(nodo)
}

function buscar() {
    listaTodo = document.getElementsByTagName("li")
    var ban = false
    var arr = [].slice.call(listaTodo);
    arr.forEach(element => {
        //console.log(element.textContent);
        if( leer() == element.textContent){
            ban = true
        }        
    });
    if( ban == true ){
        console.log("Existe")
    }else{
        console.log("NO existe")
    }
}

function buscar2() {
    //listaTodo = document.getElementsByTagName("li")
    //Buscar por ID
    if(document.getElementById(leer()) == null){
        console.log("NO existe")
    }else{
        alert("OJITO EH! Que ya existe esa madre")
    }
}

function buscar3() {
    listaTodo = document.getElementsByTagName("li")
    for (let i = 0; i < listaTodo.length; i++) {
        const tarea = listaTodo[i];
        if(leer() == tarea.textContent){
            console.log("Ya existe")
        }else{
            alert("OJITO EH! Que NO existe esa madre")
        }        
    }
}

function buscar4() {
    listaTodo = document.getElementsByTagName("li")
    for (const tarea in listaTodo) {
        if (Object.hasOwnProperty.call(listaTodo, tarea)) {
            const element = listaTodo[tarea];
            console.log(element)
            if(leer() == tarea.textContent){
                console.log("Ya existe")
            }else{
                alert("OJITO EH! Que NO existe esa madre")
            }        
        }
    }
}