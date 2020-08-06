import React from 'react';
import {
  Button,
  Image,
  StyleSheet,
  Text,
  View,
} from 'react-native';

import p0 from './imgs/p0.png'
import p1 from './imgs/p1.png'
import p2 from './imgs/p2.png'
import p3 from './imgs/p3.png'
import p4 from './imgs/p4.png'
import p5 from './imgs/p5.png'
import p6 from './imgs/p6.png'

const imgs = [p0,p1,p2,p3,p4,p5,p6]

function proxImg(indice){
  if(indice<6)
    indice+=1
  else
    indice=0  
  return indice
}

function imgAnterior(indice){
  if(indice>0)
    indice-=1
  else
    indice=6
  return indice    
}

export default class App extends React.Component{
  state = {
    indice : 0,
  }

  render(){
    return(
      <View style={styles.container}>
        <Text style={styles.text}>
          Galeria de Fotos
        </Text>  
        <Image 
          source={imgs[this.state.indice]}
          style = {styles.img}
        />
        <View style={styles.buttons}>
          <Button
            color = '#7082BF'
            onPress={ _ => this.setState({indice : imgAnterior(this.state.indice)})}
            title="IMAGEM ANTERIOR"
          />
          <Button
            color = '#7082BF'
            onPress={ _ => this.setState({indice : proxImg(this.state.indice)})}
            title="PRÓXIMA IMAGEM"
          />
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  buttons : {
    justifyContent:'space-between',
    height: 95,
    padding: 10
  },
  container : {
    backgroundColor : '#FFFEB5',
    flex: 1,
  },
  img : {
    height:200,
    width: 200,
    alignSelf: 'center',
    marginBottom: 10
  },
  text : {
    backgroundColor : '#7082BF',
    color: 'white',
    fontWeight: 'bold',
    fontSize: 20,
    padding: 15,
    marginBottom:15
  }
})