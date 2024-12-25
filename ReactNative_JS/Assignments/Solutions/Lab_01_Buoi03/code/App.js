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
            <Text style={{fontSize:60, textAlign: 'center',fontWeight: 'bold' }}>CODE</Text>
       </View>

       <View style={{flex:1}}>   
          <Text style={{fontSize:30, textAlign: 'center',fontWeight: 'bold' }}>VERTIFICATION</Text>
 
          <Text style={{fontSize:20,fontWeight: 'bold',  textAlign: 'center',marginTop: 50, marginHorizontal:25}}>Enter ontime pasword sent on ++849092605798</Text>
      </View>
       

       <View style={{flex:1,marginTop:0,justifyContent:'space-around', alignItems:'center'}}>    
          <View style={{flexDirection:'row'}}>
             <TextInput style={styles.input}
             />
             <TextInput style={styles.input}
             />
             <TextInput style={styles.input}
             />
             <TextInput style={styles.input}
             />
             <TextInput style={styles.input}
             />
             <TextInput style={styles.input}
             />

          </View>

           <TouchableOpacity style={styles.button}>
                <Text style={styles.buttonText}>VERIFY CODE</Text>
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
   },
   input:{
      width :50,
      height:50,
      borderWidth :1,
      fontSize :15,
      fontWeight :'bold',
   },
});
