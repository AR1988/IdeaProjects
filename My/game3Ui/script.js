function storageEventHandler() {
  alert(localStorage.getItem('key'));
}

window.addEventListener('storage', storageEventHandler, false);

let range = document.getElementById("btn");
range.addEventListener("click", onInputChange, false);

function onInputChange() {
  localStorage.setItem('key', Math.random().toString());
  storageEventHandler();
}

// function onStorage() {
//   //whatever
// }
//
// window.addEventListener('storage', onStorage, false);
//
// function broadcast(cmd) {
//   localStorage.setItem('command', cmd);
//   onStorage();
// }

