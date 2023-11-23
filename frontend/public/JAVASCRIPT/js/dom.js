'use strict';

window.addEventListener('DOMContentLoaded', function(){
    const h1 = document.querySelector('h1');
    
    console.log(h1);
    console.log(h1.innerText);

    h1.innerText = 'Cambiado desde JavaScript';

    const input = document.querySelector('#nombre');
    const form = document.querySelector('form');
    const span = document.querySelector('#saludo');

    form.addEventListener('submit', function(e){
        e.preventDefault();
        const nombre = input.value;

        if(nombre === 'idiota') {
            input.setCustomValidity('No seas idiota');
            input.reportValidity();
            return;
        }
        
        span.innerText = 'Hola ' + input.value;
    });

    const ul = document.querySelector('ul');

    const arr = [ 'Uno', 'Dos', 'Tres', 'Cuatro', 'Cinco' ];

    ul.innerHTML = '';

    for(let i = 0; i < arr.length; i++) {
        const li = document.createElement('li');
        li.innerText = arr[i];
        ul.appendChild(li);
    }
    
    for(const clave in arr) {
        const li = document.createElement('li');
        li.innerText = arr[clave];
        ul.appendChild(li);
    }

    for(const numero of arr) {
        const li = document.createElement('li');
        li.innerText = numero;
        ul.appendChild(li);
    }

    arr.forEach(function(numero, indice){
        const li = document.createElement('li');
        li.innerText = numero;
        ul.appendChild(li);
    });

    arr.forEach((numero, indice) => {
        const li = document.createElement('li');
        li.innerText = numero;
        ul.appendChild(li);
    });
});
