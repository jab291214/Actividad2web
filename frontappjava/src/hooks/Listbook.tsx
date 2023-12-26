import  { useEffect, useState } from 'react';
import _bookservice from '../services/BookService';

function Listbook() {
    const [data, setData] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const myService = new _bookservice();
                const result = await myService.Listado();
                setData(result.data.results); 
                console.log(data);
            } catch (error) {
                // Manejo de errores
                console.error('Error:', error);
            }
        };

        fetchData();
    }, []);
    return (
        <div>
             {data && (
        <ul>
          {data.map(item => (
            <li key={item["name"]}>{item["name"]}</li>
          ))}
        </ul>
      )}
        </div>
    );
}
export default Listbook;