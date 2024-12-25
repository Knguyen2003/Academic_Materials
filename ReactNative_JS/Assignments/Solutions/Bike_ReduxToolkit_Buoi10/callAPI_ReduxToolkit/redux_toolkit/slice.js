import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

// Tạo một async thunk để gọi API
export const fetchBikes = createAsyncThunk('bike/fetchBike', async () => {
  const response = await axios.get('https://67219f8298bbb4d93ca9023e.mockapi.io/bike');
  return response.data;
});

// Tạo slice
const bikeSlice = createSlice({
  name: 'bike',
  initialState: {
    bikes: [],
    status: 'idle', // idle | loading | succeeded | failed
    error: null,
  },
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchBikes.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(fetchBikes.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.bikes = action.payload;
      })
      .addCase(fetchBikes.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

export default bikeSlice.reducer;
