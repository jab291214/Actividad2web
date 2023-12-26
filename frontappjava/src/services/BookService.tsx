import axios from 'axios';

class BookService {
    apiClient:any;
  
    constructor() { 
        this.apiClient = axios.create({
          baseURL:import.meta.env.VITE_SERVIDOR_OPERAR_DOMINIO, // Reemplaza con la URL de tu controlador
          headers: {
            'Content-Type': 'application/json',
          },
        });
    }

    // Método para obtener datos
  public async Listado() {
    try {
      const response = await this.apiClient.get('/pokemon'); 
      console.log("Llamado listado");
      return response;
    } catch (error) {
      // Manejo de errores
      console.error('Error fetching data:', error);
      throw error;
    }
  }

  // Método para enviar datos
  async sendData(data:any) {
    try {
      const response = await this.apiClient.post('/ruta_del_controlador', data);
      return response.data;
    } catch (error) {
      // Manejo de errores
      console.error('Error sending data:', error);
      throw error;
    }
  }
}
export default BookService;