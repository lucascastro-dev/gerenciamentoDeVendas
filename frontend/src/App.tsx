import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Cabecalho from './componentes/Cabecalho'
import CartaoDeVendas from './componentes/CartaoDeVendas'

function App() {
	return (
		<>
			<ToastContainer />
			<Cabecalho />
			<main>
				<section id="sales">
					<div className="dsmeta-container">
						<CartaoDeVendas />
					</div>
				</section>
			</main>
		</>
	)
}

export default App
