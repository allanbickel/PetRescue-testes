import axios from "axios";
import { useEffect, useState } from "react";

function AnimaisCadastrados() {
	const [lista_de_animais, updateAnimais] = useState([]);

	const getData = () => {
		axios
			.get("http://localhost:8080/animais")
			.then((res) => {
				updateAnimais(res.data);
			})
			.catch((err) => console.error(err));
	};

	useEffect(() => {
		getData();
	}, []);

	return (
		<>
			<div>
				<h1>ANIMAIS CADASTRADOS:</h1>
			</div>
			{lista_de_animais.map((animal, index) => {
				return (
					<>
						<ul key={index}>
							<li>{animal.id}</li>
							<li>{animal.nome}</li>
							<li>{animal.raca}</li>
						</ul>
					</>
				);
			})}
		</>
	);
}

export default AnimaisCadastrados;
