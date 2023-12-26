const URL = 'http://localhost:3000/';
const URL_LIBROS = URL + 'libros/';
const URL_PERSONAS = URL + 'personas/';

async function obtenerLibros() {
    const respuesta = await fetch(URL_LIBROS);
    return await respuesta.json();
}

async function buscarLibro(id) {
    const respuesta = await fetch(URL_LIBROS + id);
    return await respuesta.json();
}

async function validarUsuario(email, password) {
    const respuesta = await fetch(URL_PERSONAS + '?email=' + email);
    const personas = await respuesta.json();

    if (personas.length) {
        const persona = personas[0];

        if (persona && persona.password === password) {
            return persona;
        }
    }

    return null;
}