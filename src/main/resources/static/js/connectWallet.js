let isConnected = false;
let publicKey = null;

const connectWallet = async () => {
    try {
        const response = await window.phantom.solana.connect();
        publicKey = response.publicKey.toString();
        console.log('Connected with public key:', publicKey);

        // Change the button text to "Disconnect Wallet"
        const connectButton = document.getElementById('walletButton');
        connectButton.textContent = 'Disconnect Wallet';
        isConnected = true;

        // Sign the message
        const message = 'Hello, Phantom!';
        const encodedMessage = new TextEncoder().encode(message);
        const signedMessage = await window.phantom.solana.signMessage(encodedMessage, 'utf8');
        const signature = signedMessage.signature;

        // Convert the signature to Base64
        const base64Signature = btoa(String.fromCharCode(...new Uint8Array(signature)));
        console.log('Message signed (Base64):', base64Signature);
    } catch (error) {
        console.error('Failed to connect and sign message:', error);
    }
};

const disconnectWallet = async () => {
    try {
        // Phantom does not have a direct disconnect method, but we can change the state and button text
        console.log('Disconnected from Phantom wallet');
        const connectButton = document.getElementById('walletButton');
        connectButton.textContent = 'Connect Wallet';
        isConnected = false;
        publicKey = null;
    } catch (error) {
        console.error('Failed to disconnect from Phantom wallet:', error);
    }
};

const connectAndSignButtonClicked = () => {
    if (isConnected) {
        disconnectWallet();
    } else {
        connectWallet();
    }
};

// const transferSol = async () => {
//     try {
//         const SHYFT_API_KEY = "rvjWXwlHXCtcBYgi"; // Replace with your actual API key
//         const myHeaders = new Headers();
//         myHeaders.append("x-api-key", SHYFT_API_KEY);
//         myHeaders.append("Content-Type", "application/json");

//         const raw = JSON.stringify({
//             "network": "devnet",
//             "from_address": "7q5Bu1hTXurZsnEWKhJ2PyypauEhB6jLxfHtFA4wrnU7",
//             "to_address": "3ju3xmwrKw6E6bz959yXBVtJJncPbCHv1XqwMMc2WWfv",
//             "amount": 1,
//         });

//         const requestOptions = {
//             method: 'POST',
//             headers: myHeaders,
//             body: raw,
//             redirect: 'follow'
//         };

//         const response = await fetch("https://api.shyft.to/sol/v1/wallet/send_sol", requestOptions);
//         const res = await response.json();
//         let transaction = toTransaction(res.result.encoded_transaction);
//         const signedTransaction = await window.phantom.solana.signTransaction(transaction);
//         const connection = new solanaWeb3.Connection("https://api.devnet.solana.com");
//         const signature = await connection.sendRawTransaction(signedTransaction.serialize());
//         console.log("TRANSFER SUCCESSFULLY!!! Signature:", signature);
//     } catch (error) {
//         console.log('error', error);
//     }
// };

// // Example function to convert encoded transaction to transaction object
// const toTransaction = (encodedTransaction) => {
//     const transaction = solanaWeb3.Transaction.from(Buffer.from(encodedTransaction, 'base64'));
//     return transaction;
// };


// const PRIV_KEY = "rvjWXwlHXCtcBYgi";
//         const mintNft = async () => {
//         var myHeaders = new Headers();
// 		myHeaders.append("x-api-key", PRIV_KEY);
		
// 		const fileInput = document.querySelector("#fileInput");
		
// 		var formdata = new FormData();
// 		formdata.append("network", "devnet");
// 		formdata.append("creator_wallet", publicKey);
// 		formdata.append("name", "OTHREE");
// 		formdata.append("symbol", "OTH");
// 		formdata.append("description", "OTHREE makes Web3 so easy!");
// 		formdata.append("attributes", '[{"trait_type":"dev power","value":"over 900"}]');
// 		formdata.append("external_url", "https://shyft.to");
// 		formdata.append("max_supply", "1");
// 		formdata.append("royalty", "5");
// 		formdata.append("image", fileInput.files[0]);
// 		formdata.append("fee_payer", "AaYFExyZuMHbJHzjimKyQBAH1yfA9sKTxSzBc6Nr5X4s");
		
// 		var requestOptions = {
// 		  method: 'POST',
// 		  headers: myHeaders,
// 		  body: formdata,
// 		  redirect: 'follow'
// 		};
		
// 		fetch("https://api.shyft.to/sol/v2/nft/create", requestOptions)
// 		  .then(response => response.text())
// 		  .then(result => console.log(result))
// 		  .catch(error => console.log('error', error));
// };

