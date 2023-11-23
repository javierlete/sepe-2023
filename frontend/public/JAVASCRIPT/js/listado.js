'use strict';

let form, table, inputId, inputNombre, inputPrecio;

const URL = 'http://localhost:3000/productos/';

window.addEventListener('DOMContentLoaded', async function () {
    form = document.querySelector('form');
    table = document.querySelector('table');

    inputId = document.querySelector('#id');
    inputNombre = document.querySelector('#nombre');
    inputPrecio = document.querySelector('#precio');

    form.style.display = 'none';

    form.addEventListener('submit', guardar);

    await recargarTabla();
});

async function guardar(e) {
    e.preventDefault();

    table.style.display = 'table';
    form.style.display = 'none';

    const producto = { id: inputId.value, nombre: inputNombre.value, precio: inputPrecio.value };

    if (inputId.value) {
        await fetch(URL + inputId.value, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
    } else {
        await fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
    }

    recargarTabla();
}
async function recargarTabla() {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    const tbody = document.querySelector('tbody');

    tbody.innerHTML = '';

    productos.forEach(producto => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>
                <a href="javascript:formulario(${producto.id})">Editar</a>
                <a href="javascript:borrar(${producto.id})">Borrar</a>
            </td>
            `;

        tbody.appendChild(tr);
    });
}

async function formulario(id) {
    table.style.display = 'none';
    form.style.display = 'block';

    const respuesta = await fetch(URL + id);
    const producto = await respuesta.json();

    if(id) {
        inputId.value = producto.id;
        inputNombre.value = producto.nombre;
        inputPrecio.value = producto.precio;
    } else {
        inputId.value = '';
        inputNombre.value = '';
        inputPrecio.value = '';
    }
}

async function borrar(id) {
    await fetch(URL + id, { method: 'DELETE' });
    recargarTabla();
}