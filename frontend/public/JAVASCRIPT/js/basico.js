'use strict';

console.log('Hola');

// console.log(nombre);

let nombre = 'Pepe';

console.log(nombre);

nombre = 'Juan';

console.log(nombre);

console.log(prueba);
console.log(typeof prueba);

var prueba = 'Prueba';

console.log(prueba);

console.log(typeof prueba);

console.log(typeof 5);

console.log(typeof console);

console.log(typeof console.log);

const cl = console.log;

cl('Hola a todos');

console.log(cl);

const numero = +'5';

console.log(typeof numero);
console.log(numero);

if (!isNaN(numero)) {
    console.log('Es un número');
    console.log('Es un número, por lo que el resultado es ' + (numero + 2));
} else {
    console.log('No es un numero');
}

const opcion = +'1';

switch(opcion) {
    case 1:
        console.log('Primera opción');
        break;
    case 2:
        console.log('Segunda opción');
        break;
    default:
        console.log('Opción no encontrada');
}

const arr = new Array(3);

arr[0] = 5;
arr[1] = 6;
arr[2] = 7;
arr[3] = 7;
arr[8] = 10;
arr[9] = 'sadfgagf';
arr['casa'] = 'house';
arr.perro = 'dog';

arr.push('NUEVO');

console.log(typeof arr);
console.log(arr);
console.log(arr.length);

const coleccion = [];

coleccion.push(5);
coleccion.push(6);

console.log(coleccion);

const objeto = new Object();

objeto.nombre = 'Pepe';
objeto['apellidos'] = 'Pérez';

objeto.aapellidos = 'Gutiérrez';

objeto.prueba = sumar;

console.log(objeto);

console.log(sumar(5, 6));
console.log(objeto.prueba(7, 8));

function sumar(a, b) {
    return a + b;
}

function Persona(nombre, apellidos) {
    this.nombre = nombre;
    this.apellidos = apellidos;
}

Persona.prototype.getNombreCompleto = function() {
    return this.nombre + ' ' + this.apellidos;
};

const p = new Persona('Pepe', 'Pérez');

console.log(p);
console.log(p.getNombreCompleto());

console.log(typeof p);
console.log(p instanceof Persona);
console.log(p.nombree);

console.log('Hola'.toUpperCase());

String.prototype.toUpperCase = () => 'Te fastidias';

console.log('Hola'.toUpperCase());