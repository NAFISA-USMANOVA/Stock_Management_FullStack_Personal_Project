import { describe, it, expect } from 'vitest'
import { mount } from '@vue/test-utils'

import InputForm from '../InputForm.vue'

describe('InputForm', () => {
  it('renders NavbarComponent', () => {
    const wrapper = mount(InputForm)
    // Comprobar que el componente NavbarComponent existe dentro de la vista HomeView
    expect(wrapper.findComponent(InputForm).exists()).toBe(true)
  })
})