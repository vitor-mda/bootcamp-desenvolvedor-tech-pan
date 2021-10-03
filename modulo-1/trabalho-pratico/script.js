const inputValor = document.querySelector("div.inputs div div label:nth-child(1) input");
const inputPrazoEmAnos = document.querySelector("div.inputs div div label:nth-child(2) input");
const inputJurosAoAno = document.querySelector("div.inputs div div label:nth-child(3) input");
const outputPrazoMeses = document.querySelector("main div.sumario label:nth-child(1) output");
const outputJurosMes = document.querySelector("main div.sumario label:nth-child(2) output");
const outputJurosAcumulados = document.querySelector("main div.sumario label:nth-child(3) output");
const corpoTabela = document.querySelector("main table tbody");

document.querySelector("div.button").addEventListener("click", simular);

simular();

function simular() {
    if(dadosEstaoValidos()) {
        const valorTotal = inputValor.value;
        const prazoEmMeses = inputPrazoEmAnos.value * 12;
        const jurosAoMes = (1 + parseFloat(inputJurosAoAno.value)) ** (1 / 12) - 1;
        const amortizacao = valorTotal / prazoEmMeses;
        let saldoDevedor = valorTotal;
        let jurosAcumulados = 0;

        corpoTabela.textContent = "";

        for(let i = 0, juros, total; i < prazoEmMeses; i++) {
            juros = saldoDevedor * jurosAoMes;
            jurosAcumulados += juros;
            saldoDevedor -= amortizacao;
            total = amortizacao + juros;
            corpoTabela.appendChild(criarNovaLinha(i + 1, amortizacao, juros, total));
        }

        outputPrazoMeses.textContent = prazoEmMeses;
        outputJurosMes.textContent = jurosAoMes.toFixed(6) + "...";
        outputJurosAcumulados.textContent = jurosAcumulados.toFixed(2);
    } else {

    }
}

function criarNovaLinha(prestacao, amortizacao, juros, total) {
    const novaLinha = document.createElement("tr");

    const tdPrestacao = document.createElement("td");
    tdPrestacao.textContent = prestacao;

    const tdAmortizacao = document.createElement("td");
    tdAmortizacao.textContent = amortizacao.toFixed(2);

    const tdJuros = document.createElement("td");
    tdJuros.textContent = juros.toFixed(2);

    const tdTotal = document.createElement("td");
    tdTotal.textContent = total.toFixed(2);

    novaLinha.append(tdPrestacao, tdAmortizacao, tdJuros, tdTotal);
    return novaLinha;
}

function dadosEstaoValidos() {
    return  inputValor.value > 0 &&
            inputPrazoEmAnos.value > 0 &&
            inputJurosAoAno.value > 0;
}