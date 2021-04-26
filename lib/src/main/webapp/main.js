let getAccounts = async function() {
    let resp = await fetch("api/accounts");
    let accounts = await resp.json();
    return accounts;
}

let acctTable = async function(){
    let accounts = await getAccounts();
    for(const account of accounts){
        let row = document.createElement("tr");

        let number = document.createElement("td");
        number.innerHTML = 1;
        row.appendChild(number);

        let acctName = document.createElement("td");
        acctName.innerHTML = account.acctName;
        row.appendChild(acctName);

        let acctBalance = document.createElement("td");
        acctBalance.innerHTML = account.acctBalance;
        row.appendChild(acctBalance);

        let approvalButton = document.createElement("td");
        approvalButton.innerHTML = `<form action="accountManager" method="post">
        <button name="removeAccount" class="btn btn-primary" value="` + account.acctName + `" type="submit">Remove</button>
        </form>`;
        row.appendChild(approvalButton);

        $('#acctTable').append(row);
        console.log(account.acctName);
    }
}

(async () => {
    acctTable();
})
