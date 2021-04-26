let netW = document.getElementById("netW");

let getAccounts = async function() {
    let resp = await fetch("api/accounts");
    let accounts = await resp.json();
    return accounts;
};

let acctTable = async function(){
    let accounts = await getAccounts();
    let netBalance = 0;
    let accountNum = 1;
    for(const account of accounts){
        
        netBalance += account.acctBalance;

        let row = document.createElement("tr");

        let number = document.createElement("td");
        number.innerHTML = accountNum;
        row.appendChild(number);
        accountNum++;

        let acctName = document.createElement("td");
        acctName.innerHTML = account.acctName;
        row.appendChild(acctName);

        let acctBalance = document.createElement("td");
        acctBalance.innerHTML = account.acctBalance;
        row.appendChild(acctBalance);

        $('#acctTable').append(row);
    }

    netW.innerHTML = "NetW: " + netBalance;
};



(async () => {
    acctTable();
})();
