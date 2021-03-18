
const inputStreet = document.getElementById("formUser:street");
const inputPostCode = document.getElementById("formUser:postCode");
const inputCity = document.getElementById("formUser:city");
const streetResults = document.querySelector(".streetResults");
const cityResults = document.querySelector(".cityResults");
const xhttp = new XMLHttpRequest();
const method = "GET";

//Fonction qui retire tous les enfant d'un noeud (utile pour retirer tous les résultats dans la div "results")
function removeAllChildren(tagName){
    while(tagName.childElementCount > 0){
        tagName.lastChild.remove();
    }
};

//Fonction permettant de concatener afin de générer le bon format d'url pour la requete
function concatData(input){
    let url = "";
    if(input == ""){
        url = "+";
    }else{
        url = input.toLowerCase().replace(/\s+/g, "+");
    }
    return url;
};

//Listener qui actualise les résultats lors de la frappe clavier dans l'input de "street"
inputStreet.addEventListener("keyup", function(){  

    const streetConcat = concatData(inputStreet.value);
    const url = `https://api-adresse.data.gouv.fr/search/?q=${streetConcat}&type=housenumber&autocomplete=0`;

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){

            const jsonResponse = JSON.parse(this.response);
            removeAllChildren(streetResults);
            streetResults.style.visibility ="visible";

            jsonResponse.features.map(result => {

                const div = document.createElement("div");
                div.innerHTML = `${result.properties.name} ${result.properties.postcode} ${result.properties.city}`;
                streetResults.appendChild(div);

            });
        }
    };
    xhttp.open(method, url, true);
    xhttp.send();
});

inputPostCode.addEventListener("keyup", function(){  

    const url = `https://geo.api.gouv.fr/communes?codePostal=${inputPostCode.value}`;

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){

            const jsonResponse = JSON.parse(this.response);
            removeAllChildren(cityResults);
            cityResults.style.visibility ="visible";

            jsonResponse.map(result => {

                const div = document.createElement("div");
                div.innerHTML = `${result.nom}`;
                cityResults.appendChild(div);

            });
        }
    };
    xhttp.open(method, url, true);
    xhttp.send();
});

//Remplissage automatique de la rue, code postal et ville lors du click sur un des résultats de la liste d'adresse
streetResults.addEventListener("click", function(event){
    const exactAddress = event.target.innerHTML;
    streetResults.style.visibility ="hidden";
    inputStreet.value = exactAddress.split(/\s\d{5}\s/g)[0];
    inputPostCode.value = exactAddress.match(/\b\d{5}\b/g)[0];
    inputCity.value = exactAddress.split(/\s\d{5}\s/g)[1];

});

//Remplissage automatique de la ville lors du click sur un des résultats de la liste de villes
cityResults.addEventListener("click", function(event){
    cityResults.style.visibility ="hidden";
    inputCity.value = event.target.innerHTML;
});