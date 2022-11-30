import "./App.css";

import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import AnimaisCadastrados from "./components/Animais/AnimaisCadastrados";
import Cadastro from "./components/Cadastro/Cadastro";

function App() {
	return (
		<>
			<Router>
				<Routes>
					<Route path="/" element={<Cadastro />} />
					<Route path="/animais" element={<AnimaisCadastrados />} />
				</Routes>
			</Router>
		</>
	);
}

export default App;
