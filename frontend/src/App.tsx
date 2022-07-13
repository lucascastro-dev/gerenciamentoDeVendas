import Cabecalho from './componentes/Cabecalho'
import CartaoDeVendas from './componentes/CartaoDeVendas'

function App() {
	return (
		<>
			<Cabecalho />
			<main>
				<section id="sales">
					<div className="dsmeta-container">
						<CartaoDeVendas/>
					</div>
				</section>
			</main>
		</>
	)
}

export default App
