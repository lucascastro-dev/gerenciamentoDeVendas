import axios from 'axios'
import { useEffect, useState } from 'react'
import DatePicker from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import { Venda } from '../../models/venda'
import { BASE_URL } from '../../utils/request'
import BotaoNotificacao from '../BotaoNotificacao'
import './style.css'

function CartaoDeVendas() {

	const [minDate, setMinDate] = useState(new Date(new Date().setDate(new Date().getDate() - 90)))
	const [maxDate, setMaxDate] = useState(new Date)

	const [vendas, definirVendas] = useState<Venda[]>([])

	useEffect(() => {
		axios.get(`${BASE_URL}/vendas`).then(respostaDaRequisicao => {
			definirVendas(respostaDaRequisicao.data.content)
		})
	}, [])

	return (
		<div className="dsmeta-card">
			<h2 className="dsmeta-sales-title">Vendas</h2>
			<div>
				<div className="dsmeta-form-control-container">
					<DatePicker
						selected={minDate}
						onChange={(date: Date) => setMinDate(date)}
						className="dsmeta-form-control"
						dateFormat="dd/MM/yyyy"
					/>
				</div>
				<div className="dsmeta-form-control-container">
					<DatePicker
						selected={maxDate}
						onChange={(date: Date) => setMaxDate(date)}
						className="dsmeta-form-control"
						dateFormat="dd/MM/yyyy"
					/>
				</div>
			</div>

			<div>
				<table className="dsmeta-sales-table">
					<thead>
						<tr>
							<th className="show992">ID</th>
							<th className="show576">Data</th>
							<th>Vendedor</th>
							<th className="show992">Visitas</th>
							<th className="show992">Vendas</th>
							<th>Total</th>
							<th>Notificar</th>
						</tr>
					</thead>
					<tbody>
						{
							vendas.map(venda => {
								return (
									<tr key={venda.id}>
										<td className="show992"># {venda.id}</td>
										<td className="show576">{new Date(venda.dataDaVenda).toLocaleDateString()}</td>
										<td>{venda.nomeVendedor}</td>
										<td className="show992">{venda.numeroDeVisitas}</td>
										<td className="show992">{venda.numeroDeVendas}</td>
										<td>R$ {venda.totalDaVenda.toFixed(2)}</td>
										<td>
											<div className="dsmeta-red-btn-container">
												<BotaoNotificacao />
											</div>
										</td>
									</tr>
								)
							})
						}
					</tbody>
				</table>
			</div>
		</div>
	)
}

export default CartaoDeVendas
