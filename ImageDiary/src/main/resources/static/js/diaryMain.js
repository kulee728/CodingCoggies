       function populateCalendar() {
            const calendar = document.getElementById('calendar');
            const todayInfo = document.getElementById('today-info');
            const header = document.getElementById('calendar-header');
            const today = new Date();
            const year = today.getFullYear();
            const month = today.getMonth();
            const daysInMonth = new Date(year, month + 1, 0).getDate();

            //header.textContent = `Gunhee's: ${year} ${today.toLocaleString('default', { month: 'long' })}`;
            //todayInfo.textContent = `오늘은 ${today.getFullYear()}-${(today.getMonth() + 1).toString().padStart(2, '0')}-${today.getDate().toString().padStart(2, '0')}`;
/*
            calendar.innerHTML = '';

            const firstDay = new Date(year, month, 1).getDay();

            for (let i = 0; i < firstDay; i++) {
                const dayDiv = document.createElement('div');
                dayDiv.classList.add('day');
                calendar.appendChild(dayDiv);
            }
//추후 json으로 변경
            for (let day = 1; day <= daysInMonth; day++) {
                const dayDiv = document.createElement('div');
                dayDiv.classList.add('day');
                dayDiv.textContent = day;
				
                if (day === 1 || day === 2 || day === 3) {
                    dayDiv.classList.add('star');
                }
                if (day === 5) {
                    dayDiv.classList.add('heart');
                }
                if (day === 14) {
                    dayDiv.innerHTML += '<br>Valentine\'s Day!';
                }
                if (day === 28) {
                    dayDiv.innerHTML += '<br><span style="background-color: #99ff99;">우기생일</span>';
                }
                if (day === 29) {
                    dayDiv.innerHTML += '<br><span style="background-color: #9999ff;">사수생일</span>';
                }
                if (day === 30) {
                    dayDiv.innerHTML += '<br><span style="background-color: #ff9999;">거사생일</span>';
                }

                calendar.appendChild(dayDiv);
            }*/
        }

        document.addEventListener('DOMContentLoaded', populateCalendar);
   /**
 * 
 */