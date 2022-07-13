import icone from '../../recursos/img/icone-notificacao.svg'
import './styles.css'

function BotaoNotificacao() {
	return (
		<div className="dsmeta-red-btn">
			<img src={icone} alt="Notificar" />
		</div>
	)
}

export default BotaoNotificacao
