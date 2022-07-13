import logo from '../../recursos/img/logo.svg'
import './styles.css'

function Cabecalho() {
	return (
		<header>
			<div className="dsmeta-logo-container">
				<img src={logo} alt="Gerenciador de Vendas" />
				<h1>Gerenciador de Vendas</h1>
				<p>
					Desenvolvido por
					<a href="https://github.com/lucascastro-dev"> @Lucas Castro</a>
				</p>
			</div>
		</header>
	)
}

export default Cabecalho
