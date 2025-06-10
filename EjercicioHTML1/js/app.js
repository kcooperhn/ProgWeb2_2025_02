function addTask() {
  const taskInput = document.getElementById('new-task');
  const taskText = taskInput.value.trim();
  if (taskText === '') return;

  const li = document.createElement('li');
  li.innerHTML = `
                  <span onclick="toggleTask(this)" style="cursor: pointer;">${taskText}</span>
                  <button class="delete-btn" onclick="deleteTask(this)">Eliminar</button>
              `;
  var tareas = document.getElementById('task-list');
  tareas.appendChild(li);
  document.getElementById("contador").textContent = tareas.childNodes.length;
  taskInput.value = '';
}

function toggleTask(element) {
  element.classList.toggle('completed');
}

function deleteTask(element) {
  element.parentElement.remove();
  document.getElementById("contador").textContent = document.getElementById('task-list').childNodes.length;
}

document.getElementById('new-task').addEventListener('keypress', function(e) {
  if (e.key === 'Enter') {
    addTask();
  }
});
