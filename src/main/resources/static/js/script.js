const buttonOne = document.getElementById('one');
const buttonTwo = document.getElementById('two');
const buttonThree = document.getElementById('three');

const simulationForm = document.querySelector('.tab-sim');
const coordsForm = document.querySelector('.tab-coord');
const infoForm = document.querySelector('.tab-info');

const simulationNav = document.querySelector('.tab-nav-sim');
const coordsNav = document.querySelector('.tab-nav-coord');
const infoNav = document.querySelector('.tab-nav-info');

const amount = document.getElementById('amount');
const duration = document.getElementById('duration');
const monthly = document.getElementById('monthly');
const email = document.getElementById('email');
const phone = document.getElementById('phone');

buttonOne.addEventListener("click", e => {
    e.preventDefault;
    console.log("PASS");
    if(amount.value != "" && duration.value != "" && monthly.value != ""){
        simulationForm.style.display="none";
        coordsForm.style.display="block";
        simulationNav.style.color="white";
        coordsNav.style.color="#30435C";
        simulationNav.style.backgroundColor = "#02AFBC";
        coordsNav.style.backgroundColor = "#FDDF35";
        console.log("PASS 2");
    }
})

buttonTwo.addEventListener("click", e => {
    e.preventDefault;
    if(email.value != "" && phone.value != ""){
        coordsForm.style.display="none";
        infoForm.style.display="block";
        coordsNav.style.color="white";
        infoNav.style.color="#30435C"
        coordsNav.style.backgroundColor="#02AFBC";
        infoNav.style.backgroundColor="#FDDF35";
    }
})