import {StyleSheet,Dimensions } from 'react-native';


const screenWidth = Dimensions.get('window').width;
const styles = StyleSheet.create({
   text:{
      fontSize: 20,
      color: 'black',
   },
   button:{
      height:50,
      width :screenWidth - 20*2,
      backgroundColor: 'red', 
      justifyContent:'center',
      alignItems:'center',
      borderRadius :15,

   },
  buttonDetail:{
      height:50,
      width :screenWidth - 20*2,
      backgroundColor: 'blue', 
      justifyContent:'center',
      alignItems:'center',
      borderRadius :15,
   },
   button4:{
      height:50,
      width :screenWidth - 20*2,
      backgroundColor: 'white', 
      justifyContent:'center',
      alignItems:'center',
      borderRadius :15,
      borderWidth:1

   },
   buttonText:{
     fontWeight:'bold',
     color:'white',
     fontSize:25,
   },
   buttonText4:{
     fontWeight:'bold',
     color:'black',
     fontSize:25,
   }
});

export default styles;