/**
 * Validar campos obrigatórios do formulário de criação de novo cadastro de produto
 */

function validar() {
	let codigo = frmProduto.codigo.value
	let nome = frmProduto.nome.value
	let valor = frmProduto.valor.value
	let quantidade = frmProduto.quantidade.value

	if (codigo === "") {
		alert('Preencha o campo Código')
		frmProduto.codigo.focus()
		return false
	} else if (nome === "") {
		alert('Preencha o campo Nome')
		frmProduto.nome.focus()
		return false
	} else if (valor === "") {
		alert('Preencha o campo Valor')
		frmProduto.valor.focus()
		return false
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade')
		frmProduto.quantidade.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}

}

function validar2() {
	let codigo = frmEditarProduto.codigo.value
	let nome = frmEditarProduto.nome.value
	let valor = frmEditarProduto.valor.value
	let quantidade = frmEditarProduto.quantidade.value

	if (codigo === "") {
		alert('Preencha o campo Código')
		frmEditarProduto.codigo.focus()
		return false
	} else if (nome === "") {
		alert('Preencha o campo Nome')
		frmEditarProduto.nome.focus()
		return false
	} else if (valor === "") {
		alert('Preencha o campo Valor')
		frmEditarProduto.valor.focus()
		return false
	} else if (quantidade === "") {
		alert('Preencha o campo Quantidade')
		frmEditarProduto.quantidade.focus()
		return false
	} else {
		alert("Alteração realizada com sucesso!")
		document.forms["frmEditarProduto"].submit()
	}

}