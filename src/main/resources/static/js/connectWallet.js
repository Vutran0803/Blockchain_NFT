document.addEventListener('DOMContentLoaded', function () {
    const getKeyButton = document.getElementById('getKeyButton');
    getKeyButton.addEventListener('click', setKeyInInput);

    if (localStorage.getItem('isConnected') === 'true') {
        isConnected = true;
        publicKey = localStorage.getItem('publicKey');
        base64Signature = localStorage.getItem('base64Signature');
        const connectButton = document.getElementById('walletButton');
        connectButton.textContent = 'Disconnect Wallet';
        console.log('Connected with public key:', publicKey);
        console.log('Message signed (Base64):', base64Signature);
        displayForm();
        startDisconnectTimer();
    } else {
        hideForm();
    }
});

const connectWallet = async () => {
    try {
        const response = await window.phantom.solana.connect();
        publicKey = response.publicKey.toString();
        console.log('Connected with public key:', publicKey);

        const connectButton = document.getElementById('walletButton');
        connectButton.textContent = 'Disconnect Wallet';
        isConnected = true;

        localStorage.setItem('isConnected', 'true');
        localStorage.setItem('publicKey', publicKey);

        const message = 'Hello, Phantom!';
        const encodedMessage = new TextEncoder().encode(message);
        const signedMessage = await window.phantom.solana.signMessage(encodedMessage, 'utf8');
        const signature = signedMessage.signature;

        base64Signature = btoa(String.fromCharCode(...new Uint8Array(signature)));
        console.log('Message signed (Base64):', base64Signature);

        localStorage.setItem('base64Signature', base64Signature);
        displayForm();
        startDisconnectTimer();
    } catch (error) {
        console.error('Failed to connect and sign message:', error);
    }
};

const disconnectWallet = async () => {
    try {
        console.log('Disconnected from Phantom wallet');
        const connectButton = document.getElementById('walletButton');
        connectButton.textContent = 'Connect Wallet';
        isConnected = false;
        publicKey = null;
        base64Signature = null;

        localStorage.removeItem('isConnected');
        localStorage.removeItem('publicKey');
        localStorage.removeItem('base64Signature');
        hideForm();

        clearTimeout(disconnectTimeout);
        disconnectTimeout = null;
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

function displayForm() {
    document.getElementById('connectMessage').style.display = 'none';
    document.querySelectorAll('#formContainer').forEach(el => el.style.display = 'block');
    document.getElementById('wallet').value = publicKey;
}

function hideForm() {
    document.getElementById('connectMessage').style.display = 'block';
    document.querySelectorAll('#formContainer').forEach(el => el.style.display = 'none');
}

function startDisconnectTimer() {
    if (disconnectTimeout) {
        clearTimeout(disconnectTimeout);
    }
    disconnectTimeout = setTimeout(() => {
        disconnectWallet();
    }, 10800000);
}

function setKeyInInput() {
    if (isConnected && publicKey) {
        const keyInput = document.getElementById('recipient');
        keyInput.value = publicKey;
    } else {
        console.log('Wallet not connected');
    }
}
