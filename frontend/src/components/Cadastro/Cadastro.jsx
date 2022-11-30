import { useForm } from "react-hook-form";
import axios from "axios";
import { BrowserRouter as Router, Link } from "react-router-dom";

function Cadastro() {
	const { register, handleSubmit, reset } = useForm();

	const onSubmit = (data) => {
		axios
			.post("http://localhost:8080/cadastro", data)
			.then((res) => console.log(res))
			.catch((err) => console.log(err));
		reset();
	};

	return (
		<>
			<div>
				<form onSubmit={handleSubmit(onSubmit)}>
					<input type="text" name="nome" {...register("nome")} />
					<br />
					<input type="text" name="raca" {...register("raca")} />
					<br />
					<button type="submit">Submit</button>
				</form>
				<br />
			</div>

			<div>
				<Link to="/animais">
					<button>Ver Animais</button>
				</Link>
			</div>
		</>
	);
}

export default Cadastro;
