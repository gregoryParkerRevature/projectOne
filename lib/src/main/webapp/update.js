let accountSelect = document.getElementById("accountSelect");

let getAccounts = async function() {
    let resp = await fetch("api/accounts");
    let accounts = await resp.json();
    return accounts;
}

let acctSelect = async function (){
    let accounts = await getAccounts();
    for(const account of accounts){
        let option = document.createElement("option");
        option.text = account.acctName;
        option.value = account.acctName;
        console.log(account.acctName);
        accountSelect.appendChild(option);
    }
}

(async () => {
    acctSelect();
})