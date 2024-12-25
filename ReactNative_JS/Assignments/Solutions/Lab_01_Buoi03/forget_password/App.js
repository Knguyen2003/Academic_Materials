import React from 'react';
import {Text, View, Image, TouchableOpacity,StyleSheet,Dimensions,TextInput } from 'react-native';


const YourApp = () => {
  return (
    <View style={{flex: 1, backgroundColor: '#C7F4F6'}}>
       <View style={{
                     flex:2,
                     justifyContent:'center',
                     alignItems:'center',
                  }}>      
            <Image source = {{uri:'https://picsum.photos/200'}} style={{height:200, width:200,borderRadius:100 }} />
       </View>

       <View style={{flex:1}}>   
          <Text style={{fontSize:40, textAlign: 'center',fontWeight: 'bold' }}>FORGET {'\n'} PASSWORD</Text>
 
          <Text style={{fontSize:18,fontWeight: 'bold',  textAlign: 'center',marginVertical: 10, marginHorizontal:25}}>Provide your account's email for which you want to reset your password</Text>
      </View>
       

       <View style={{flex:1,marginTop:0,justifyContent:'space-around', alignItems:'center'}}>    
           <TextInput style={{
                 width :screenWidth - 25*2,
                 height:50,
                 backgroundColor: 'lightgray',
                 placeholder:'Email',
                 fontSize :15,
                 fontWeight :'bold',
           }}
           placeholder="Email"
           />

           <TouchableOpacity style={styles.button}>
                <Text style={styles.buttonText}>NEXT</Text>
           </TouchableOpacity>
       </View>

        <View style={{flex:1}}>
        </View>

    </View>
  );
};

export default YourApp;

const screenWidth = Dimensions.get('window').width;

const styles = StyleSheet.create({
   button :{
       height:50,
       width :screenWidth - 25*2,
       backgroundColor: 'yellow', 
       justifyContent:'center',
       alignItems:'center',

   },
   buttonText:{
      fontSize: 20,
      fontWeight: 'bold',
      color: 'black',
   }
});
