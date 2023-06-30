// Obtener referencias a los elementos del DOM
const listarPacientesBtn = document.getElementById('listar-pacientes-btn');
const nuevoPacienteBtn = document.getElementById('nuevo-paciente-btn');
const pacientesList = document.getElementById('pacientes-list');
const buscarPacienteInput = document.getElementById('buscar-paciente-input');
const buscarPacienteBtn = document.getElementById('buscar-paciente-btn');
const pacienteEncontrado = document.getElementById('paciente-encontrado');

const listarOdontologosBtn = document.getElementById('listar-odontologos-btn');
const nuevoOdontologoBtn = document.getElementById('nuevo-odontologo-btn');
const odontologosList = document.getElementById('odontologos-list');
const buscarOdontologoInput = document.getElementById('buscar-odontologo-input');
const buscarOdontologoBtn = document.getElementById('buscar-odontologo-btn');
const odontologoEncontrado = document.getElementById('odontologo-encontrado');

const listarTurnosBtn = document.getElementById('listar-turnos-btn');
const nuevoTurnoBtn = document.getElementById('nuevo-turno-btn');
const turnosList = document.getElementById('turnos-list');
const buscarTurnoInput = document.getElementById('buscar-turno-input');
const buscarTurnoBtn = document.getElementById('buscar-turno-btn');
const turnoEncontrado = document.getElementById('turno-encontrado');

// Función para obtener la lista de pacientes
function listarPacientes() {
    fetch('http://localhost:8080/api/pacientes', {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            pacientesList.innerHTML = '';
            data.forEach(paciente => {
                const pacienteItem = document.createElement('div');
                pacienteItem.textContent = `${paciente.id}: ${paciente.nombre} ${paciente.apellido}`;
                pacientesList.appendChild(pacienteItem);
            });
        });
}

// Función para buscar un paciente por ID
function buscarPaciente() {
    const pacienteId = buscarPacienteInput.value;
    fetch(`http://localhost:8080/api/pacientes/${pacienteId}`, {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            pacienteEncontrado.textContent = `Paciente encontrado: ${data.nombre} ${data.apellido}`;
        })
        .catch(error => {
            pacienteEncontrado.textContent = 'Paciente no encontrado';
            console.error(error);
        });
}

// Función para obtener la lista de odontólogos
function listarOdontologos() {
    fetch('http://localhost:8080/api/odontologos', {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            odontologosList.innerHTML = '';
            data.forEach(odontologo => {
                const odontologoItem = document.createElement('div');
                odontologoItem.textContent = `${odontologo.id}: ${odontologo.nombre} ${odontologo.apellido}`;
                odontologosList.appendChild(odontologoItem);
            });
        });
}

// Función para buscar un odontólogo por ID
function buscarOdontologo() {
    const odontologoId = buscarOdontologoInput.value;
    fetch(`http://localhost:8080/api/odontologos/${odontologoId}`, {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            odontologoEncontrado.textContent = `Odontólogo encontrado: ${data.nombre} ${data.apellido}`;
        })
        .catch(error => {
            odontologoEncontrado.textContent = 'Odontólogo no encontrado';
            console.error(error);
        });
}

// Función para obtener la lista de turnos
function listarTurnos() {
    fetch('http://localhost:8080/api/turnos', {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            turnosList.innerHTML = '';
            data.forEach(turno => {
                const turnoItem = document.createElement('div');
                turnoItem.textContent = `${turno.id}: ${turno.fecha} - Paciente: ${turno.paciente} - Odontólogo: ${turno.odontologo}`;
                turnosList.appendChild(turnoItem);
            });
        });
}

// Función para buscar un turno por ID
function buscarTurno() {
    const turnoId = buscarTurnoInput.value;
    fetch(`http://localhost:8080/api/turnos/${turnoId}`, {
        mode: 'cors'
    })
        .then(response => response.json())
        .then(data => {
            turnoEncontrado.textContent = `Turno encontrado: ${data.fecha} - Paciente: ${data.paciente} - Odontólogo: ${data.odontologo}`;
        })
        .catch(error => {
            turnoEncontrado.textContent = 'Turno no encontrado';
            console.error(error);
        });
}

// Asignar eventos a los botones
listarPacientesBtn.addEventListener('click', listarPacientes);
nuevoPacienteBtn.addEventListener('click', () => {
    // Lógica para agregar un nuevo paciente
    console.log('Agregar nuevo paciente');
});
buscarPacienteBtn.addEventListener('click', buscarPaciente);

listarOdontologosBtn.addEventListener('click', listarOdontologos);
nuevoOdontologoBtn.addEventListener('click', () => {
    // Lógica para agregar un nuevo odontólogo
    console.log('Agregar nuevo odontólogo');
});
buscarOdontologoBtn.addEventListener('click', buscarOdontologo);

listarTurnosBtn.addEventListener('click', listarTurnos);
nuevoTurnoBtn.addEventListener('click', () => {
    // Lógica para agregar un nuevo turno
    console.log('Agregar nuevo turno');
});
buscarTurnoBtn.addEventListener('click', buscarTurno);