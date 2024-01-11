const URL = '/biblioteca/api/v1';
const URL_LIBROS = URL + '/usuario/libros/';
const URL_PERSONAS = URL + '/anonimo/login';

async function obtenerLibros() {
    const respuesta = await fetch(URL_LIBROS);
    return await respuesta.json();
}

async function buscarLibro(id) {
    const respuesta = await fetch(URL_LIBROS + id);
    return await respuesta.json();
}

async function validarUsuario(email, password) {
    const respuesta = await fetch(`${URL_PERSONAS}?email=${email}&password=${password}`);

    if (!respuesta.ok) {
        return null;
    }

    const persona = await respuesta.json();

    console.log('validarUsuario', persona);

    return persona;
}