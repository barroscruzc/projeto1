/**
 * Confirmação de exclusão de um produto do banco de dados
 */

function confirmar(id, nome) {
	let resposta = confirm("Confirma a EXCLUSÃO do produto " + nome + "? Esta ação NÃO poderá ser desfeita.")
	if (resposta === true) {
		alert("Exclusão realizada com sucesso!")
		window.location.href = "delete?id=" + id
	}
}