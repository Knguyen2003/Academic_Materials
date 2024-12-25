import React from 'react';
import {Text, View, Image, TouchableOpacity,StyleSheet } from 'react-native';

const YourApp = () => {
  return (
    <View style={{flex: 1, backgroundColor: '#00CCF9'}}>
       <View style={{
                     flex:2,
                     justifyContent:'center',
                     alignItems:'center',
                  }}>      
            <View style={{
                     width: 200,
                     height: 200,
                     borderRadius: 100,
                     backgroundColor: 'black', // Placeholder for circle
                     marginBottom: 20,
                     justifyContent:'center',
                     alignItems:'center',
            }}>
               <View style={{
                     width: 150,
                     height: 150,
                     borderRadius: 100,
                     backgroundColor: '#00CCF9', // Placeholder for circlea
               }}>
               </View>
            </View>
       </View>

       <View style={{flex:1}}>   
          <Text style={{fontSize:40, textAlign: 'center',fontWeight: 'bold' }}>GROW {'\n'} YOUR BUSINESS</Text>
       </View>

       <View style={{flex:1}}>    
          <Text style={{fontSize:20,fontWeight: 'bold',  textAlign: 'center',marginVertical: 10, marginHorizontal:10}}>We will help to you grow your business using online server </Text>
       </View>

       <View style={{flex:1,flexDirection: 'row',justifyContent:'space-around', alignItems:'center'}}>    
           <TouchableOpacity style={styles.button}>
                <Text style={styles.buttonText}>LOGIN</Text>
           </TouchableOpacity>

           <TouchableOpacity style={styles.button}>
                <Text style={styles.buttonText}>SIGN UP</Text>
           </TouchableOpacity>
       </View>
       
     
    </View>
  );
};

export default YourApp;

const styles = StyleSheet.create({
   button :{
       backgroundColor: 'yellow', 
       paddingVertical: 10,
       paddingHorizontal: 30,
       borderRadius: 10,
       marginHorizontal: 10,  //trai phai
   },
   buttonText:{
      fontSize: 16,
      fontWeight: 'bold',
      color: 'black',
   }
});
