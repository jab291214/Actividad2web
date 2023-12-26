import  { Component} from 'react'   
import Listbook from '../hooks/Listbook'
export class Books extends Component {
    
 
  render() {
    return (
      <div className='box'>  
        Listado
        <Listbook/>
      </div>
      
    )
  }
}

export default Books